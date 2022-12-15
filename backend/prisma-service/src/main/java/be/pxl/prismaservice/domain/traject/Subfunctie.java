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
@Table(name = "subfunctie")
public class Subfunctie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    @OneToMany(mappedBy = "subfunctie", cascade = CascadeType.ALL)
    private List<Antwoord> antwoorden;
    private String opmerking;
    private boolean prioriteit;
    @ManyToOne(cascade = CascadeType.ALL)
    private Functie functie;
}
