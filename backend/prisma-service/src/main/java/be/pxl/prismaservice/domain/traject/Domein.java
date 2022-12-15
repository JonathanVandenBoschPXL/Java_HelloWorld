package be.pxl.prismaservice.domain.traject;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "domein")
public class Domein {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    private String kleur;
    @OneToMany(mappedBy = "domein", cascade = CascadeType.ALL)
    private List<Functie> functie;
    @OneToOne(mappedBy = "domein")
    private Traject traject;
}
