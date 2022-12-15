package be.pxl.prismaservice.domain.request.traject.situering;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SitueringRequest {
    private String talenten;
    private String kwetsbaarheden;
}
