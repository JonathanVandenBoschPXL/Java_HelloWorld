package be.pxl.prismaservice.services;

import be.pxl.prismaservice.domain.response.KindProfile;

public interface IKindService {
    KindProfile getById(Long id);
}
