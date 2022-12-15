package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.User;
import be.pxl.prismaservice.domain.UserRol;
import be.pxl.prismaservice.domain.response.KindOverzicht;
import be.pxl.prismaservice.exceptions.UserNotFoundException;
import be.pxl.prismaservice.infrastructure.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest extends TestBase{

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl service;

    private Kind kind1;
    private Kind kind2;

    @BeforeEach
    void setUp() {
        kind1 = genereerKind(1L);
        kind2 = genereerKind(2L);
    }

    @Test
    void gegevenBestaandeUserMetKinderen_vindAlleKinderen_returnsJuisteKinderen(){
        List<Kind> listKind = new ArrayList<>();
        listKind.add(kind1);
        listKind.add(kind2);
        List<KindOverzicht> result = new ArrayList<>();
        KindOverzicht kindOverzicht1 = maakKindOverzicht(kind1);
        result.add(kindOverzicht1);
        KindOverzicht kindOverzicht2 = maakKindOverzicht(kind2);
        result.add(kindOverzicht2);
        User user = User.builder()
                .id(1L)
                .rol(UserRol.OUDER)
                .kinderen(listKind).build();

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(modelMapper.map(kind1, KindOverzicht.class)).thenReturn(kindOverzicht1);
        when(modelMapper.map(kind2, KindOverzicht.class)).thenReturn(kindOverzicht2);

        List<KindOverzicht> list = service.vindAlleKinderenMetUserId(user.getId());
        assertEquals(list.size(), result.size());
        assertEquals(list.get(0), kindOverzicht1);
        assertEquals(list.get(1), kindOverzicht2);
        verify(userRepository, times(1)).findById(user.getId());
    }

    @Test
    void gegevenOnbestaandeUser_vindAlleKinderen_returnsUserNotfoundException() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                ()-> service.vindAlleKinderenMetUserId(userId));

        verify(userRepository, times(1)).findById(userId);
        assertEquals(UserNotFoundException.MESSAGE, exception.getMessage());
    }

    @Test
    void gegevenBestaandeUserZonderKinderen_vindAlleKinderen_returnsLegeLijst() {
        User user = User.builder()
                .id(1L)
                .kinderen(Collections.emptyList())
                .build();

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        List<KindOverzicht> lijstVanKinderen = service.vindAlleKinderenMetUserId(user.getId());

        assertEquals(Collections.emptyList(), lijstVanKinderen);
        verify(userRepository, times(1)).findById(user.getId());
    }


}