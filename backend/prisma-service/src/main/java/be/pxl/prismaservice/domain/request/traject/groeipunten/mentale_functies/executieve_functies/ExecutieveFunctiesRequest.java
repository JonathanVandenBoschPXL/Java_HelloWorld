package be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.executieve_functies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecutieveFunctiesRequest {
    private FormExecutieveFunctiesRequest antwoorden;
    private String opmerking;
    private boolean prioriteit;
}
