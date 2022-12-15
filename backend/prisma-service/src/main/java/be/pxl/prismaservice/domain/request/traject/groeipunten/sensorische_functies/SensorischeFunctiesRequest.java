package be.pxl.prismaservice.domain.request.traject.groeipunten.sensorische_functies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorischeFunctiesRequest {
    private FormSensorischeFunctiesRequest antwoorden;
    private String opmerking;
    private boolean prioriteit;
}
