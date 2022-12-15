package be.pxl.prismaservice.services;

import be.pxl.prismaservice.domain.request.traject.TrajectRequest;
import be.pxl.prismaservice.domain.response.VindTrajectResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectOverzichtResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectResponse;

import java.util.List;

public interface ITrajectService {
    VindTrajectResponse vindTrajectPerKindPerUser(Long userId, Long kindId);
    TrajectOverzichtResponse voegTrajectToeAanKindEnUser(Long userId, Long kindId, TrajectRequest trajectRequest);
    List<TrajectResponse> vindTraject(Long userId, Long kindId);
    List<TrajectResponse> vindAlleTrajectenVanKindBehalveMeestRecent(Long kindId, Long trajectTeVerwijderenId);
    List<TrajectResponse> vindAlleTrajectenVanKind(Long kindId);

}
