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
@Table(name = "functie")
public class Functie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    @OneToMany(mappedBy = "functie", cascade = { CascadeType.ALL})
    private List<Subfunctie> subfunctie;
    @ManyToOne(cascade = CascadeType.ALL)
    private Domein domein;
}
