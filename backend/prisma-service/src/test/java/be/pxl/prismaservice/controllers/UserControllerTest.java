package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.Kind;
import be.pxl.prismaservice.domain.response.KindOverzicht;
import be.pxl.prismaservice.exceptions.UserNotFoundException;
import be.pxl.prismaservice.services.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(value = UserController.class)
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
class UserControllerTest extends TestBase {

    // https://stackoverflow.com/questions/57960618/springboot-testing-with-keycloak
    @MockBean
    private IUserService service;

    @Autowired
    private MockMvc mockMvc;

    private final Long USER_ID = 1L;

    @Test
    @WithMockUser(roles = {"LEERKRACHT", "user"})
    void gegevenBestaandeUserMetKinderen_getOverzichtKinderen_returnsLijstVanJuisteKinderen() throws Exception {
        Kind kind1 = genereerKind(1L);
        Kind kind2 = genereerKind(2L);
        KindOverzicht kindOverzicht1 = maakKindOverzicht(kind1);
        KindOverzicht kindOverzicht2 = maakKindOverzicht(kind2);
        List<KindOverzicht> kindOverzichtLijst = List.of(kindOverzicht1, kindOverzicht2);
        when(service.vindAlleKinderenMetUserId(USER_ID)).thenReturn(kindOverzichtLijst);

        mockMvc.perform(MockMvcRequestBuilders
                        .get(String.format("/user/%d/kinderen", USER_ID))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(kindOverzichtLijst.size())))
                .andExpect(jsonPath("$[0].achternaam").value(kindOverzicht1.getAchternaam()))
                .andExpect(jsonPath("$[0].voornaam").value(kindOverzicht1.getVoornaam()))
                .andExpect(jsonPath("$[0].id").value(kindOverzicht1.getId()))
                .andExpect(jsonPath("$[1].achternaam").value(kindOverzicht2.getAchternaam()))
                .andExpect(jsonPath("$[1].voornaam").value(kindOverzicht2.getVoornaam()))
                .andExpect(jsonPath("$[1].id").value(kindOverzicht2.getId()));
    }

    @Test
    void gegevenBestaandeUserZonderKinderen_getOverzichtKinderen_returnsLegeLijst() throws Exception {
        when(service.vindAlleKinderenMetUserId(USER_ID)).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/user/%d/kinderen", USER_ID))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
    @Test
    void gegevenOnbestaandeUser_getOverzichtKinderen_returnsNotFound() throws Exception {
        doThrow(UserNotFoundException.class)
                .when(service)
                .vindAlleKinderenMetUserId(USER_ID);

        mockMvc.perform(MockMvcRequestBuilders
                        .get(String.format("/user/%d/kinderen", USER_ID))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}