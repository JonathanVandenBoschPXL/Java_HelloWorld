package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.domain.User;
import be.pxl.prismaservice.domain.response.KindOverzicht;
import be.pxl.prismaservice.exceptions.UserNotFoundException;
import be.pxl.prismaservice.infrastructure.UserRepository;
import be.pxl.prismaservice.services.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<KindOverzicht> vindAlleKinderenMetUserId(Long userId) {
            Optional<User> user = userRepository.findById(userId);
            if(user.isEmpty()){
                log.info("De gebruiker met id {} werd niet gevonden",
                        userId);
                throw new UserNotFoundException();
            }
            return user.get().getKinderen().stream()
                    .map(kind -> modelMapper.map(kind, KindOverzicht.class))
                    .toList();
    }
}
