package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.User;
import be.pxl.prismaservice.domain.UserRol;
import be.pxl.prismaservice.domain.response.VindTrajectResponse;
import be.pxl.prismaservice.domain.traject.Traject;
import be.pxl.prismaservice.infrastructure.TrajectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrajectServiceImplTest extends TestBase {

    @Mock
    private TrajectRepository trajectRepository;

    @InjectMocks
    private TrajectServiceImpl service;

    private Kind kind1;

    private User user1;

    @BeforeEach
    void setUp() {
        kind1 = genereerKind(1L);
        List<Kind> listKinderen = List.of(kind1);
        user1 = User.builder()
                .id(1L)
                .rol(UserRol.OUDER)
                .kinderen(listKinderen)
                .build();
    }

    @Test
    void gegevenKindZonderTrajecten_vindTrajectPerKindPerUser_returnsFalseAndFalse() {
        when(trajectRepository.findByUserIdAndKindId(user1.getId(), kind1.getId()))
                .thenReturn(Optional.of(Collections.emptyList()));
        when(trajectRepository.findByKindId(kind1.getId()))
                .thenReturn(Optional.of(Collections.emptyList()));

        VindTrajectResponse trajectResponse = service.vindTrajectPerKindPerUser(user1.getId(), kind1.getId());
        assertFalse(trajectResponse.isKindHeeftTrajecten());
        assertFalse(trajectResponse.isUserHeeftTrajectenVanDitKind());
    }

    @Test
    void gegevenKindHeeftTrajectMaarVanAndereUser_vindTrajectPerKinderPerUser_returnsTrueAndFalse() {
        when(trajectRepository.findByUserIdAndKindId(user1.getId(), kind1.getId()))
                .thenReturn(Optional.of(Collections.emptyList()));
        when(trajectRepository.findByKindId(kind1.getId())).thenReturn(Optional.of(List.of(new Traject())));

        VindTrajectResponse trajectResponse = service.vindTrajectPerKindPerUser(user1.getId(), kind1.getId());
        assertTrue(trajectResponse.isKindHeeftTrajecten());
        assertFalse(trajectResponse.isUserHeeftTrajectenVanDitKind());
    }

    @Test
    void gegevenKindHeeftMeerdereTrajectenVanVerschillendeAndereUsers_vindTrajectPerKindPerUser_returnsTrueAndFalse(){
        when(trajectRepository.findByUserIdAndKindId(user1.getId(), kind1.getId()))
                .thenReturn(Optional.of(Collections.emptyList()));
        when(trajectRepository.findByKindId(kind1.getId())).thenReturn(Optional.of(List.of(new Traject(), new Traject(), new Traject())));

        VindTrajectResponse trajectResponse = service.vindTrajectPerKindPerUser(user1.getId(), kind1.getId());

        assertTrue(trajectResponse.isKindHeeftTrajecten());
        assertFalse(trajectResponse.isUserHeeftTrajectenVanDitKind());
    }

    @Test
    void gegevenKindHeeftTrajectVanUser_vindTrajectPerKindPerUser_returnsTrueAndTrue() {
        when(trajectRepository.findByUserIdAndKindId(user1.getId(), kind1.getId()))
                .thenReturn(Optional.of(List.of(new Traject())));
        when(trajectRepository.findByKindId(kind1.getId())).thenReturn(Optional.of(List.of(new Traject())));

        VindTrajectResponse trajectResponse = service.vindTrajectPerKindPerUser(user1.getId(), kind1.getId());
        assertTrue(trajectResponse.isKindHeeftTrajecten());
        assertTrue(trajectResponse.isUserHeeftTrajectenVanDitKind());
    }

    @Test
    void gegevenKindHeeftMeerdereTrajectenVanUser_vindTrajectPerKindPerUser_returnsTrueAndTrue() {
        when(trajectRepository.findByUserIdAndKindId(user1.getId(), kind1.getId()))
                .thenReturn(Optional.of(List.of(new Traject(), new Traject())));
        when(trajectRepository.findByKindId(kind1.getId())).thenReturn(Optional.of(List.of(new Traject(), new Traject())));

        VindTrajectResponse trajectResponse = service.vindTrajectPerKindPerUser(user1.getId(), kind1.getId());
        assertTrue(trajectResponse.isKindHeeftTrajecten());
        assertTrue(trajectResponse.isUserHeeftTrajectenVanDitKind());
    }

    @Test
    void gegevenKindHeeftMeerdereTrajectenVanVerschillendeUsers_vindTrajectPerKindPerUser_returnsTrueAndTrue() {
        when(trajectRepository.findByUserIdAndKindId(user1.getId(), kind1.getId()))
                .thenReturn(Optional.of(List.of(new Traject())));
        when(trajectRepository.findByKindId(kind1.getId())).thenReturn(Optional.of(List.of(new Traject(), new Traject())));

        VindTrajectResponse trajectResponse = service.vindTrajectPerKindPerUser(user1.getId(), kind1.getId());
        assertTrue(trajectResponse.isKindHeeftTrajecten());
        assertTrue(trajectResponse.isUserHeeftTrajectenVanDitKind());
    }
}
