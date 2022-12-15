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
public class SubfunctieResponse {
    private String naam;
    private List<AntwoordResponse> antwoorden;
    private String opmerking;
    private boolean prioriteit;
}
