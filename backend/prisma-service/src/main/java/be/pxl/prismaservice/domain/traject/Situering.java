package be.pxl.prismaservice.domain.traject;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "situering")
public class Situering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String antwoord1;
    private String antwoord2;
    @OneToOne(mappedBy = "situering")
    private Traject traject;
}
