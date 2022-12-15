package be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.theory_of_mind;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormTheorieOfMindRequest {
    private boolean letterlijkBegrijpenTaal;
    private boolean moeitePerspectiefname;
}
