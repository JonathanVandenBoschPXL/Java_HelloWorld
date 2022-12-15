package be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.executieve_functies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormExecutieveFunctiesRequest {
    private boolean doelGerichtHandelen;
    private boolean emotieRegulatie;
    private boolean flexibiliteit;
    private boolean metacognitie;
    private boolean organisatie;
    private boolean planning;
    private boolean responsinhibitie;
    private boolean taakinitiatie;
    private boolean timemanagement;
    private boolean volgehoudenAandacht;
    private boolean werkgeheugen;
}
