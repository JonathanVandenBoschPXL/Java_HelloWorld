package be.pxl.prismaservice.domain.request.traject;

import be.pxl.prismaservice.domain.request.traject.groeipunten.GroeipuntenRequest;
import be.pxl.prismaservice.domain.request.traject.situering.SitueringRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrajectRequest {
    private SitueringRequest situering;
    private GroeipuntenRequest groeipunten;
}
