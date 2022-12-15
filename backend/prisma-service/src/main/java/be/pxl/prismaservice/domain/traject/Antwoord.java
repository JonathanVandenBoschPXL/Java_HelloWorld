package be.pxl.prismaservice.domain.traject;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "antwoord")
public class Antwoord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    private boolean ingevuld;
    @ManyToOne(cascade = CascadeType.ALL)
    private Subfunctie subfunctie;
}
