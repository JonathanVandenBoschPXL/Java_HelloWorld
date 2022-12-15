package be.pxl.prismaservice.infrastructure;

import be.pxl.prismaservice.domain.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindRepository extends JpaRepository<Kind, Long> {
}
