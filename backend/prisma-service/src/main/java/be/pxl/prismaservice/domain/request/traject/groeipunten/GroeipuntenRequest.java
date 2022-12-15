package be.pxl.prismaservice.domain.request.traject.groeipunten;

import be.pxl.prismaservice.domain.request.traject.groeipunten.beweging_functies.BewegingFunctiesRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.MentaleFunctieRequest;
import be.pxl.prismaservice.domain.request.traject.groeipunten.sensorische_functies.SensorischeFunctiesRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroeipuntenRequest {
    private MentaleFunctieRequest mentaleFunctie;
    private SensorischeFunctiesRequest sensorischeFunctie;
    private BewegingFunctiesRequest bewegingsFunctie;
}
