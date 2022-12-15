package be.pxl.prismaservice.domain.response.traject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DomeinResponse {
    private String naam;
    private String kleur;
    private List<FunctieResponse> functie;
}
