package be.pxl.prismaservice.domain.request.traject.groeipunten.beweging_functies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BewegingFunctiesRequest {
    private FormBewegingFunctiesRequest antwoorden;
    private String opmerking;
    private boolean prioriteit;
}
