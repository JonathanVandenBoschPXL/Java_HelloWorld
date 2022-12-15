package be.pxl.prismaservice;

import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.request.traject.TrajectRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.GroeipuntenRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.beweging_functies.BewegingFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.MentaleFunctieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.centrale_coherentie.CentraleCoherentieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.centrale_coherentie.FormCentraleCoherentieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.executieve_functies.ExecutieveFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.executieve_functies.FormExecutieveFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.socio_emotionele_ontwikkeling.FormSocioEmotioneleOntwikkelingRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.socio_emotionele_ontwikkeling.SocioEmotioneleOntwikkelingRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.theory_of_mind.FormTheorieOfMindRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.theory_of_mind.TheorieOfMindRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.sensorische_functies.FormSensorischeFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.sensorische_functies.SensorischeFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.situering.SitueringRequest;
import be.pxl.prismaservice.domain.response.KindOverzicht;
import be.pxl.prismaservice.domain.response.KindProfile;
import be.pxl.prismaservice.domain.response.traject.TrajectOverzichtResponse;

import java.time.LocalDate;

public class TestBase {

    protected Kind genereerKind(Long kindId) {
        LocalDate geboorteDatum = LocalDate.of(2000, 5, (int) (1 + kindId));
        return Kind.builder()
                .id(kindId)
                .achternaam("Achternaam" + kindId)
                .voornaam("Voornaam" + kindId)
                .geboorteDatum(geboorteDatum)
                .adres("adres" + kindId)
                .school("school" + kindId)
                .klas("klas" + kindId)
                .rijksregisternummer(genereerRijksregisterNummer(geboorteDatum, kindId))
                .build();
    }

    protected KindOverzicht maakKindOverzicht(Kind kind){
        return KindOverzicht.builder()
                .achternaam(kind.getAchternaam())
                .voornaam(kind.getVoornaam())
                .id(kind.getId())
                .build();
    }

    protected KindProfile maakKindProfile(Kind kind){
        return KindProfile.builder()
                .achternaam(kind.getAchternaam())
                .voornaam(kind.getVoornaam())
                .id(kind.getId())
                .adres(kind.getAdres())
                .school(kind.getSchool())
                .klas(kind.getKlas())
                .build();
    }

    private String genereerRijksregisterNummer(LocalDate geboorteDatum, Long kindId) {
        String jaar = String.valueOf(geboorteDatum.getYear()).substring(1,3);
        String maand = String.format("%02d", geboorteDatum.getMonthValue());
        String dag = String.format("%02d", geboorteDatum.getDayOfMonth());
        String laatsteVijfCijfers = String.format("%05d", kindId);
        return jaar + maand + dag + laatsteVijfCijfers;
    }
}
