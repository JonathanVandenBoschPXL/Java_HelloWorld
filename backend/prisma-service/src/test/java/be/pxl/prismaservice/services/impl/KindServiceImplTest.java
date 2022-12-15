package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.response.KindProfile;
import be.pxl.prismaservice.exceptions.KindNotFoundException;
import be.pxl.prismaservice.infrastructure.KindRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KindServiceImplTest extends TestBase {
    @Mock
    private KindRepository kindRepository;
    @Mock
    private ModelMapper mapper;
    @InjectMocks
    private KindServiceImpl service;
    private Kind kind;

    @BeforeEach
    void setUp() {
        kind = genereerKind(1L);
    }
    @Test
    void getByID_returnsJuistKind(){
        KindProfile kindProfile = maakKindProfile(kind);

        when(kindRepository.findById(kind.getId())).thenReturn(Optional.of(kind));
        when(mapper.map(Optional.of(kind),KindProfile.class)).thenReturn(kindProfile);

        KindProfile gekrijgenProfile = service.getById(kind.getId());
        Assertions.assertEquals(kindProfile, gekrijgenProfile);
        verify(kindRepository, times(1)).findById(kind.getId());
    }

    @Test
    void getByID_returnsKindNotFoundException() {
        Long id = 1L;
        when(kindRepository.findById(id)).thenReturn(Optional.empty());
        KindNotFoundException exception = assertThrows(KindNotFoundException.class,
                ()-> service.getById(id));

        verify(kindRepository, times(1)).findById(id);
        assertEquals(KindNotFoundException.MESSAGE, exception.getMessage());
    }




}