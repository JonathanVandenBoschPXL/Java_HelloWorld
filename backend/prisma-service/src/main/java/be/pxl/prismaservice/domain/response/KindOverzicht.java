package be.pxl.prismaservice.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KindOverzicht {

    private Long id;
    private String voornaam;
    private String achternaam;
    private String geslacht;
}
