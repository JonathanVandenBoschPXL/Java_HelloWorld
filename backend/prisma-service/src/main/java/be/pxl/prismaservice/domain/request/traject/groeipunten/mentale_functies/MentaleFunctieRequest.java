package be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies;

import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.centrale_coherentie.CentraleCoherentieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.executieve_functies.ExecutieveFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.socio_emotionele_ontwikkeling.SocioEmotioneleOntwikkelingRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.theory_of_mind.TheorieOfMindRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentaleFunctieRequest {
    private CentraleCoherentieRequest centraleCoherentie;
    private ExecutieveFunctiesRequest executieveFuncties;
    private SocioEmotioneleOntwikkelingRequest socioEmotioneleOntwikkeling;
    private TheorieOfMindRequest theoryOfMind;
}
