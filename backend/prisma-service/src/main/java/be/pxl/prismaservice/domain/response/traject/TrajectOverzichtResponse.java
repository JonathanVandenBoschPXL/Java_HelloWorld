package be.pxl.prismaservice.domain.response.traject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrajectOverzichtResponse {
    private Long id;
    private Long userId;
    private Long kindId;
    private LocalDate datumVanOpslaan;
}
