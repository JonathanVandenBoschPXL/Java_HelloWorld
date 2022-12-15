package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.response.KindProfile;
import be.pxl.prismaservice.exceptions.KindNotFoundException;
import be.pxl.prismaservice.exceptions.UserNotFoundException;
import be.pxl.prismaservice.infrastructure.KindRepository;
import be.pxl.prismaservice.services.IKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KindServiceImpl implements IKindService {
    private final KindRepository kindRepository;
    private final ModelMapper modelMapper;

    @Override
    public KindProfile getById(Long kindId) {
        Optional<Kind> kind = kindRepository.findById(kindId);
        if(kind.isEmpty()){
            log.info("De kind met id {} werd niet gevonden",kindId);
            throw new KindNotFoundException();
        }
        return modelMapper.map(kind, KindProfile.class);
    }
}
