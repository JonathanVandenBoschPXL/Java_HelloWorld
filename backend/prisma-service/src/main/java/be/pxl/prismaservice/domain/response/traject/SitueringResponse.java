package be.pxl.prismaservice.domain.response.traject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SitueringResponse {
    private String antwoord1;
    private String antwoord2;
}
