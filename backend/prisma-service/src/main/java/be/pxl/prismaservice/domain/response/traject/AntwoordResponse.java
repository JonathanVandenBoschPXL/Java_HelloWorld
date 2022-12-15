package be.pxl.prismaservice.domain.response.traject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AntwoordResponse {
    private String naam;
    private boolean ingevuld;
}
