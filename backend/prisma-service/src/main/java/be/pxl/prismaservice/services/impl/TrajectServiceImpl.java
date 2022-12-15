package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.User;
import be.pxl.prismaservice.domain.request.traject.TrajectRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.GroeipuntenRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.beweging_functies.BewegingFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.MentaleFunctieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.centrale_coherentie.CentraleCoherentieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.executieve_functies.ExecutieveFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.socio_emotionele_ontwikkeling.SocioEmotioneleOntwikkelingRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.theory_of_mind.TheorieOfMindRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.sensorische_functies.SensorischeFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.situering.SitueringRequest;
import be.pxl.prismaservice.domain.response.VindTrajectResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectOverzichtResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectResponse;
import be.pxl.prismaservice.domain.traject.*;
import be.pxl.prismaservice.exceptions.TrajectNotFoundException;
import be.pxl.prismaservice.infrastructure.KindRepository;
import be.pxl.prismaservice.infrastructure.TrajectRepository;
import be.pxl.prismaservice.infrastructure.UserRepository;
import be.pxl.prismaservice.services.ITrajectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrajectServiceImpl implements ITrajectService {

    private final TrajectRepository trajectRepository;
    private final UserRepository userRepository;
    private final KindRepository kindRepository;
    private final ModelMapper modelMapper;

    public VindTrajectResponse vindTrajectPerKindPerUser(Long userId, Long kindId) {
        Optional<List<Traject>> userTrajecten = trajectRepository.findByUserIdAndKindId(userId, kindId);
        Optional<List<Traject>> kindTrajecten = trajectRepository.findByKindId(kindId);

        return VindTrajectResponse
                .builder()
                .kindHeeftTrajecten(kindTrajecten.filter(trajecten -> !trajecten.isEmpty()).isPresent())
                .userHeeftTrajectenVanDitKind(userTrajecten.filter(trajecten -> !trajecten.isEmpty()).isPresent())
                .build();
    }

    public List<TrajectResponse> vindTraject(Long userId, Long kindId){
        Optional<List<Traject>> trajecten = trajectRepository.findByUserIdAndKindId(userId, kindId);
        if (trajecten.isEmpty()){
            log.info("user met userId {} heeft geen trajecten van kindId {}", userId, kindId);
            throw new TrajectNotFoundException();
        }
        List<TrajectResponse> trajectResponses = new ArrayList<>();
        for (Traject traject : trajecten.get()) {
            trajectResponses.add(modelMapper.map(traject, TrajectResponse.class));
        }
        trajectResponses.sort(Collections.reverseOrder());
        return trajectResponses;
    }

    @Override
    public List<TrajectResponse> vindAlleTrajectenVanKindBehalveMeestRecent(Long kindId, Long trajectTeVerwijderenId) {
        List<TrajectResponse> trajectResponses = getAlleTrajectenVanKind(kindId);
        trajectResponses.removeIf(trajectResponse -> trajectResponse.getId().equals(trajectTeVerwijderenId));
        return trajectResponses;
    }
    @Override
    public List<TrajectResponse> vindAlleTrajectenVanKind(Long kindId) {
        return getAlleTrajectenVanKind(kindId);
    }

    public TrajectOverzichtResponse voegTrajectToeAanKindEnUser(Long userId, Long kindId, TrajectRequest trajectRequest) {
        Traject traject = new Traject();

        traject.setDomein(maakDomein(trajectRequest.getGroeipunten(), traject));
        traject.setSituering(maakSituering(trajectRequest.getSituering(), traject));
        traject.setDatumLaatstAangepast(LocalDate.now());

        Optional<User> foundUser = userRepository.findById(userId);
        foundUser.ifPresent(traject::setUser);
        Optional<Kind> foundKind = kindRepository.findById(kindId);
        foundKind.ifPresent(traject::setKind);

        Traject savedTraject = trajectRepository.save(traject);

        return new TrajectOverzichtResponse(savedTraject.getId(), savedTraject.getUser().getId(),
                savedTraject.getKind().getId(), savedTraject.getDatumLaatstAangepast());
    }

    private List<TrajectResponse> getAlleTrajectenVanKind(Long kindId) {
        Optional<List<Traject>> trajecten = trajectRepository.findByKindId(kindId);
        if (trajecten.isEmpty()){
            log.info("trajecten van kindId {} niet gevonden",  kindId);
            throw new TrajectNotFoundException();
        }
        List<TrajectResponse> trajectResponses = new ArrayList<>();
        for (Traject traject : trajecten.get()) {
            trajectResponses.add(modelMapper.map(traject, TrajectResponse.class));
        }
        return trajectResponses;
    }

    private Situering maakSituering(SitueringRequest situeringRequest, Traject traject){
        Situering situering = new Situering();
        situering.setAntwoord1(situeringRequest.getTalenten());
        situering.setAntwoord2(situeringRequest.getKwetsbaarheden());
        situering.setTraject(traject);

        return situering;
    }

    private Domein maakDomein(GroeipuntenRequest groeipuntenRequest, Traject traject){
        Domein domein = new Domein();
        domein.setNaam("Geel");
        domein.setKleur("Geel");

        List<Functie> functies = new ArrayList<>();
        functies.add(maakFunctieMentaleFunctie(groeipuntenRequest.getMentaleFunctie(), domein));
        functies.add(maakFunctieSensorischeFuncties(groeipuntenRequest.getSensorischeFunctie(), domein));
        functies.add(maakFunctieBewegingFuncties(groeipuntenRequest.getBewegingsFunctie(), domein));

        domein.setFunctie(functies);
        domein.setTraject(traject);

        return domein;
    }

    private Functie maakFunctieBewegingFuncties(BewegingFunctiesRequest bewegingFunctiesRequest, Domein domein){
        Functie bewegingsFuncties = new Functie();
        bewegingsFuncties.setNaam("Bewegingssysteem en aan beweging verwante functies");

        List<Subfunctie> subfuncties = new ArrayList<>();

        Subfunctie bewegingsSubFunctie = new Subfunctie();
        bewegingsSubFunctie.setNaam("Bewegingsfunctie");
        bewegingsSubFunctie.setAntwoorden(maakBewegingsSubFunctieAntwoorden(bewegingFunctiesRequest, bewegingsSubFunctie));
        bewegingsSubFunctie.setOpmerking(bewegingFunctiesRequest.getOpmerking());
        bewegingsSubFunctie.setFunctie(bewegingsFuncties);
        bewegingsSubFunctie.setPrioriteit(bewegingFunctiesRequest.isPrioriteit());
        subfuncties.add(bewegingsSubFunctie);

        bewegingsFuncties.setSubfunctie(subfuncties);
        bewegingsFuncties.setDomein(domein);

        return bewegingsFuncties;
    }

    private List<Antwoord> maakBewegingsSubFunctieAntwoorden(BewegingFunctiesRequest bewegingFunctiesRequest, Subfunctie subfunctie){
        List<Antwoord> antwoorden = new ArrayList<>();

        Antwoord motorischeVaardigheden = new Antwoord();
        motorischeVaardigheden.setNaam("Beperkte grove of fijnmotorische vaardigheden");
        motorischeVaardigheden.setIngevuld(bewegingFunctiesRequest.getAntwoorden().isMotorischeVaardigheden());
        motorischeVaardigheden.setSubfunctie(subfunctie);
        antwoorden.add(motorischeVaardigheden);

        Antwoord spierspanning = new Antwoord();
        spierspanning.setNaam("Hoge spierspanning - houterig bewegen - tenengang");
        spierspanning.setIngevuld(bewegingFunctiesRequest.getAntwoorden().isSpierspanning());
        spierspanning.setSubfunctie(subfunctie);
        antwoorden.add(spierspanning);

        Antwoord coordinatievermogen = new Antwoord();
        coordinatievermogen.setNaam("Beperkte coördinatievermogen bij motorische handelingen");
        coordinatievermogen.setIngevuld(bewegingFunctiesRequest.getAntwoorden().isCoordinatievermogen());
        coordinatievermogen.setSubfunctie(subfunctie);
        antwoorden.add(coordinatievermogen);

        return antwoorden;
    }

    private Functie maakFunctieSensorischeFuncties(SensorischeFunctiesRequest sensorischeFunctiesRequest, Domein domein){
        Functie sensorischeFuncties = new Functie();
        sensorischeFuncties.setNaam("Sensorische Functies");

        List<Subfunctie> subfuncties = new ArrayList<>();

        Subfunctie sensorischeSubFunctie = new Subfunctie();
        sensorischeSubFunctie.setNaam("Sensorische Functie");
        sensorischeSubFunctie.setAntwoorden(maakSensorischeSubFunctieAntwoorden(sensorischeFunctiesRequest, sensorischeSubFunctie));
        sensorischeSubFunctie.setOpmerking(sensorischeFunctiesRequest.getOpmerking());
        sensorischeSubFunctie.setFunctie(sensorischeFuncties);
        sensorischeSubFunctie.setPrioriteit(sensorischeFunctiesRequest.isPrioriteit());
        subfuncties.add(sensorischeSubFunctie);

        sensorischeFuncties.setSubfunctie(subfuncties);
        sensorischeFuncties.setDomein(domein);

        return sensorischeFuncties;
    }

    private List<Antwoord> maakSensorischeSubFunctieAntwoorden(SensorischeFunctiesRequest sensorischeFunctiesRequest, Subfunctie subfunctie){
        List<Antwoord> antwoorden = new ArrayList<>();

        Antwoord overprikkeling = new Antwoord();
        overprikkeling.setNaam("Overprikkeling");
        overprikkeling.setIngevuld(sensorischeFunctiesRequest.getAntwoorden().isOverprikkeling());
        overprikkeling.setSubfunctie(subfunctie);
        antwoorden.add(overprikkeling);

        Antwoord onderprikkeling = new Antwoord();
        onderprikkeling.setNaam("Onderprikkeling");
        onderprikkeling.setIngevuld(sensorischeFunctiesRequest.getAntwoorden().isOnderprikkeling());
        onderprikkeling.setSubfunctie(subfunctie);
        antwoorden.add(onderprikkeling);

        Antwoord visueleDenkers = new Antwoord();
        visueleDenkers.setNaam("Visuele denkers");
        visueleDenkers.setIngevuld(sensorischeFunctiesRequest.getAntwoorden().isVisueleDenkers());
        visueleDenkers.setSubfunctie(subfunctie);
        antwoorden.add(visueleDenkers);

        return antwoorden;
    }

    private Functie maakFunctieMentaleFunctie(MentaleFunctieRequest mentaleFunctieRequest, Domein domein){
        Functie mentaleFuncties = new Functie();
        mentaleFuncties.setNaam("Mentale Functies");

        List<Subfunctie> subfuncties = new ArrayList<>();

        Subfunctie centraleCoherentie = new Subfunctie();
        centraleCoherentie.setNaam("Centrale Coherentie");
        centraleCoherentie.setAntwoorden(maakCentraleCoherentieAntwoorden(mentaleFunctieRequest.getCentraleCoherentie(), centraleCoherentie));
        centraleCoherentie.setOpmerking(mentaleFunctieRequest.getCentraleCoherentie().getOpmerking());
        centraleCoherentie.setFunctie(mentaleFuncties);
        centraleCoherentie.setPrioriteit(mentaleFunctieRequest.getCentraleCoherentie().isPrioriteit());
        subfuncties.add(centraleCoherentie);

        Subfunctie executieveFuncties = new Subfunctie();
        executieveFuncties.setNaam("Executieve Functies");
        executieveFuncties.setAntwoorden(maakExecutieveFunctiesAntwoorden(mentaleFunctieRequest.getExecutieveFuncties(), executieveFuncties));
        executieveFuncties.setOpmerking(mentaleFunctieRequest.getExecutieveFuncties().getOpmerking());
        executieveFuncties.setFunctie(mentaleFuncties);
        executieveFuncties.setPrioriteit(mentaleFunctieRequest.getExecutieveFuncties().isPrioriteit());
        subfuncties.add(executieveFuncties);

        Subfunctie theoryOfMind = new Subfunctie();
        theoryOfMind.setNaam("Theory of Mind");
        theoryOfMind.setAntwoorden(maakTheoryOfMindAntwoorden(mentaleFunctieRequest.getTheoryOfMind(), theoryOfMind));
        theoryOfMind.setOpmerking(mentaleFunctieRequest.getTheoryOfMind().getOpmerking());
        theoryOfMind.setFunctie(mentaleFuncties);
        theoryOfMind.setPrioriteit(mentaleFunctieRequest.getTheoryOfMind().isPrioriteit());
        subfuncties.add(theoryOfMind);

        Subfunctie socioEmotioneleOntwikkeling = new Subfunctie();
        socioEmotioneleOntwikkeling.setNaam("Socio-emotionele ontwikkeling");
        socioEmotioneleOntwikkeling.setAntwoorden(maakSocioEmotioneleOntwikkelingAntwoorden(mentaleFunctieRequest.getSocioEmotioneleOntwikkeling(), socioEmotioneleOntwikkeling));
        socioEmotioneleOntwikkeling.setOpmerking(mentaleFunctieRequest.getSocioEmotioneleOntwikkeling().getOpmerking());
        socioEmotioneleOntwikkeling.setFunctie(mentaleFuncties);
        socioEmotioneleOntwikkeling.setPrioriteit(mentaleFunctieRequest.getSocioEmotioneleOntwikkeling().isPrioriteit());
        subfuncties.add(socioEmotioneleOntwikkeling);

        mentaleFuncties.setSubfunctie(subfuncties);
        mentaleFuncties.setDomein(domein);

        return mentaleFuncties;
    }

    private List<Antwoord> maakSocioEmotioneleOntwikkelingAntwoorden(SocioEmotioneleOntwikkelingRequest socioEmotioneleOntwikkelingRequest, Subfunctie subfunctie){
        List<Antwoord> antwoorden = new ArrayList<>();

        Antwoord persoonlijkheid = new Antwoord();
        persoonlijkheid.setNaam("Persoonlijkheid");
        persoonlijkheid.setIngevuld(socioEmotioneleOntwikkelingRequest.getAntwoorden().isPersoonlijkheid());
        persoonlijkheid.setSubfunctie(subfunctie);
        antwoorden.add(persoonlijkheid);

        return antwoorden;
    }

    private List<Antwoord> maakTheoryOfMindAntwoorden(TheorieOfMindRequest theorieOfMindRequest, Subfunctie subfunctie){
        List<Antwoord> antwoorden = new ArrayList<>();

        Antwoord letterlijkBegrijpenVanTaal = new Antwoord();
        letterlijkBegrijpenVanTaal.setNaam("Letterlijk begrijpen van taal");
        letterlijkBegrijpenVanTaal.setIngevuld(theorieOfMindRequest.getAntwoorden().isLetterlijkBegrijpenTaal());
        letterlijkBegrijpenVanTaal.setSubfunctie(subfunctie);
        antwoorden.add(letterlijkBegrijpenVanTaal);

        Antwoord moeiteMetPerspectiefname = new Antwoord();
        moeiteMetPerspectiefname.setNaam("Moeite met perspectiefname");
        moeiteMetPerspectiefname.setIngevuld(theorieOfMindRequest.getAntwoorden().isMoeitePerspectiefname());
        moeiteMetPerspectiefname.setSubfunctie(subfunctie);
        antwoorden.add(moeiteMetPerspectiefname);

        return antwoorden;
    }

    private List<Antwoord> maakExecutieveFunctiesAntwoorden(ExecutieveFunctiesRequest executieveFunctiesRequest, Subfunctie subfunctie){
        List<Antwoord> antwoorden = new ArrayList<>();

        Antwoord reponsinhibitie = new Antwoord();
        reponsinhibitie.setNaam("Responsinhibitie");
        reponsinhibitie.setIngevuld(executieveFunctiesRequest.getAntwoorden().isResponsinhibitie());
        reponsinhibitie.setSubfunctie(subfunctie);
        antwoorden.add(reponsinhibitie);

        Antwoord werkgeheugen = new Antwoord();
        werkgeheugen.setNaam("Werkgeheugen");
        werkgeheugen.setIngevuld(executieveFunctiesRequest.getAntwoorden().isWerkgeheugen());
        werkgeheugen.setSubfunctie(subfunctie);
        antwoorden.add(werkgeheugen);

        Antwoord emotieRegulatie = new Antwoord();
        emotieRegulatie.setNaam("Emotie-Regulatie");
        emotieRegulatie.setIngevuld(executieveFunctiesRequest.getAntwoorden().isEmotieRegulatie());
        emotieRegulatie.setSubfunctie(subfunctie);
        antwoorden.add(emotieRegulatie);

        Antwoord volgehoudenAandacht = new Antwoord();
        volgehoudenAandacht.setNaam("Volgehouden aandacht");
        volgehoudenAandacht.setIngevuld(executieveFunctiesRequest.getAntwoorden().isVolgehoudenAandacht());
        volgehoudenAandacht.setSubfunctie(subfunctie);
        antwoorden.add(volgehoudenAandacht);

        Antwoord taakinitiatie = new Antwoord();
        taakinitiatie.setNaam("Taakinitiatie");
        taakinitiatie.setIngevuld(executieveFunctiesRequest.getAntwoorden().isTaakinitiatie());
        taakinitiatie.setSubfunctie(subfunctie);
        antwoorden.add(taakinitiatie);

        Antwoord planning = new Antwoord();
        planning.setNaam("Planning");
        planning.setIngevuld(executieveFunctiesRequest.getAntwoorden().isPlanning());
        planning.setSubfunctie(subfunctie);
        antwoorden.add(planning);

        Antwoord organisatie = new Antwoord();
        organisatie.setNaam("Organisatie");
        organisatie.setIngevuld(executieveFunctiesRequest.getAntwoorden().isOrganisatie());
        organisatie.setSubfunctie(subfunctie);
        antwoorden.add(organisatie);

        Antwoord timemanagement = new Antwoord();
        timemanagement.setNaam("Timemanagement");
        timemanagement.setIngevuld(executieveFunctiesRequest.getAntwoorden().isTimemanagement());
        timemanagement.setSubfunctie(subfunctie);
        antwoorden.add(timemanagement);

        Antwoord doelgerichtHandelen = new Antwoord();
        doelgerichtHandelen.setNaam("Doelgericht handelen");
        doelgerichtHandelen.setIngevuld(executieveFunctiesRequest.getAntwoorden().isDoelGerichtHandelen());
        doelgerichtHandelen.setSubfunctie(subfunctie);
        antwoorden.add(doelgerichtHandelen);

        Antwoord flexibiliteit = new Antwoord();
        flexibiliteit.setNaam("Flexibiliteit");
        flexibiliteit.setIngevuld(executieveFunctiesRequest.getAntwoorden().isFlexibiliteit());
        flexibiliteit.setSubfunctie(subfunctie);
        antwoorden.add(flexibiliteit);

        Antwoord metacognitie = new Antwoord();
        metacognitie.setNaam("Metacognitie");
        metacognitie.setIngevuld(executieveFunctiesRequest.getAntwoorden().isMetacognitie());
        metacognitie.setSubfunctie(subfunctie);
        antwoorden.add(metacognitie);

        return antwoorden;
    }

    private List<Antwoord> maakCentraleCoherentieAntwoorden(CentraleCoherentieRequest centraleCoherentieRequest, Subfunctie subfunctie){
        List<Antwoord> antwoorden = new ArrayList<>();

        Antwoord gerichtOpDetails = new Antwoord();
        gerichtOpDetails.setNaam("Gericht op details");
        gerichtOpDetails.setIngevuld(centraleCoherentieRequest.getAntwoorden().isGerichtOpDetail());
        gerichtOpDetails.setSubfunctie(subfunctie);
        antwoorden.add(gerichtOpDetails);

        Antwoord moeizaamGeheelZien = new Antwoord();
        moeizaamGeheelZien.setNaam("Moeizaam het geheel zien");
        moeizaamGeheelZien.setIngevuld(centraleCoherentieRequest.getAntwoorden().isMoeizaamGeheelZien());
        moeizaamGeheelZien.setSubfunctie(subfunctie);
        antwoorden.add(moeizaamGeheelZien);

        Antwoord vaardighedenContextAfhankelijk = new Antwoord();
        vaardighedenContextAfhankelijk.setNaam("Vaardigheden zijn contextafhankelijk");
        vaardighedenContextAfhankelijk.setIngevuld(centraleCoherentieRequest.getAntwoorden().isVaardighedenContextAfhankelijk());
        vaardighedenContextAfhankelijk.setSubfunctie(subfunctie);
        antwoorden.add(vaardighedenContextAfhankelijk);

        return antwoorden;
    }
}
