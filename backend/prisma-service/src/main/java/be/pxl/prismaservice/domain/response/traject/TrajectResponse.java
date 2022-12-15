package be.pxl.prismaservice.domain.response.traject;

import be.pxl.prismaservice.domain.traject.Traject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrajectResponse implements Comparable<TrajectResponse> {
    private Long id;
    private DomeinResponse domein;
    private SitueringResponse situering;
    private LocalDate datumLaatstAangepast;
    private UserResponse user;
    @Override
    public int compareTo(TrajectResponse o) {
        return getDatumLaatstAangepast().compareTo(o.getDatumLaatstAangepast());
    }
}
