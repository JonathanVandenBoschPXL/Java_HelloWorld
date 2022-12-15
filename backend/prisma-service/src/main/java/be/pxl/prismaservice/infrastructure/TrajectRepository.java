package be.pxl.prismaservice.infrastructure;

import be.pxl.prismaservice.domain.traject.Traject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrajectRepository extends JpaRepository<Traject, Long> {

    Optional<List<Traject>> findByUserIdAndKindId(Long userId, Long kindId);
    Optional<List<Traject>> findByKindId(Long kindId);
}
