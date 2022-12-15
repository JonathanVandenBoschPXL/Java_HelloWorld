package be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.centrale_coherentie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormCentraleCoherentieRequest {
    private boolean gerichtOpDetail;
    private boolean moeizaamGeheelZien;
    private boolean vaardighedenContextAfhankelijk;
}
