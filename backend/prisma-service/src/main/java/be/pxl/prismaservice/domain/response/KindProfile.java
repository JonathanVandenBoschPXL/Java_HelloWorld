package be.pxl.prismaservice.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KindProfile {
    private Long id;
    private String voornaam;
    private String achternaam;
    private LocalDate geboortedatum;
    private String adres;
    private String school;
    private String klas;
    private String geslacht;
}
