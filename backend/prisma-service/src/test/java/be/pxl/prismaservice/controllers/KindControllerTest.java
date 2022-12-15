package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.response.KindProfile;
import be.pxl.prismaservice.exceptions.UserNotFoundException;
import be.pxl.prismaservice.services.IKindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = KindController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class KindControllerTest extends TestBase {
    @MockBean
    private IKindService service;
    @Autowired
    private MockMvc mockMvc;
    private final Long ID = 1L;

    @Test
    void getKindBijId_returnsProfileVanJuisteKind() throws Exception{
        Kind kind =  genereerKind(1L);
        KindProfile kindProfile = maakKindProfile(kind);
        when(service.getById(ID)).thenReturn(kindProfile);
        mockMvc.perform(MockMvcRequestBuilders
                    .get(String.format("/kind/%d", ID))
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.achternaam").value(kindProfile.getAchternaam()))
                .andExpect(jsonPath("$.voornaam").value(kindProfile.getVoornaam()))
                .andExpect(jsonPath("$.geboortedatum").value(kindProfile.getGeboortedatum()))
                .andExpect(jsonPath("$.adres").value(kindProfile.getAdres()))
                .andExpect(jsonPath("$.school").value(kindProfile.getSchool()))
                .andExpect(jsonPath("$.klas").value(kindProfile.getKlas()));
    }
    @Test
    void gegevenOnbestaandeUser_getOverzichtKinderen_returnsNotFound() throws Exception {
        doThrow(UserNotFoundException.class)
                .when(service)
                .getById(ID);

        mockMvc.perform(MockMvcRequestBuilders
                        .get(String.format("/kind/%d", ID))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}