package be.pxl.prismaservice.domain.traject;

import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.User;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "traject")
public class Traject implements Comparable<Traject>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Domein domein;
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Situering situering;
    private LocalDate datumLaatstAangepast;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kind kind;

    @Override
    public int compareTo(Traject o) {
        return getDatumLaatstAangepast().compareTo(o.getDatumLaatstAangepast());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traject traject = (Traject) o;
        return id.equals(traject.id) && domein.equals(traject.domein) && situering.equals(traject.situering) && datumLaatstAangepast.equals(traject.datumLaatstAangepast) && user.equals(traject.user) && kind.equals(traject.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domein, situering, datumLaatstAangepast, user, kind);
    }
}
