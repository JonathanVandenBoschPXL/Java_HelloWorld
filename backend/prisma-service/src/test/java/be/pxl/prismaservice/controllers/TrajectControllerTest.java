package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.request.traject.TrajectRequest;
import be.pxl.prismaservice.domain.response.VindTrajectResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectOverzichtResponse;
import be.pxl.prismaservice.services.ITrajectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = TrajectController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class TrajectControllerTest extends TestBase {

    @MockBean
    private ITrajectService trajectService;

    @Autowired
    private MockMvc mockMvc;

    private final Long USER_ID = 1L;
    private final Long KIND_ID = 1L;

    @Test
    void gegevenKindZonderTrajecten_getTrajectPerKindPerUser_returnsJuisteVindTrajectResponse() throws Exception {
        VindTrajectResponse response = VindTrajectResponse.builder()
                .kindHeeftTrajecten(false)
                .userHeeftTrajectenVanDitKind(false)
                .build();

        when(trajectService.vindTrajectPerKindPerUser(USER_ID, KIND_ID))
                .thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders
                    .get(String.format("/traject/%d/kind/%d", USER_ID, KIND_ID))
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.kindHeeftTrajecten").value(response.isKindHeeftTrajecten()))
                .andExpect(jsonPath("$.userHeeftTrajectenVanDitKind").value(response.isUserHeeftTrajectenVanDitKind()));
    }
}
