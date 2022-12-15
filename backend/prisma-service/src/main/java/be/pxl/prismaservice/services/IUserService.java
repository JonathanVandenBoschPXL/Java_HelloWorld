package be.pxl.prismaservice.services;
import be.pxl.prismaservice.domain.response.KindOverzicht;
import java.util.List;

public interface IUserService {
    List<KindOverzicht> vindAlleKinderenMetUserId(Long userId);
}
