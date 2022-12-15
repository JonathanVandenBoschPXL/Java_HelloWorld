package be.pxl.prismaservice.domain;

import be.pxl.prismaservice.domain.traject.Traject;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "kind")
public class Kind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String voornaam;
    private String achternaam;
    @Column(unique = true)
    private String rijksregisternummer;
    private LocalDate geboorteDatum;
    private String adres;
    private String school;
    private String klas;
    private String geslacht;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_kind",
            joinColumns = {
                    @JoinColumn(name = "kind_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    @ToString.Exclude
    private List<User> users;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kind")
    private List<Traject> trajecten;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Kind kind = (Kind) o;
        return id != null && Objects.equals(id, kind.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
