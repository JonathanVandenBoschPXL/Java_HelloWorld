package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.request.EmailRequest;
import be.pxl.prismaservice.services.IEmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ContactController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class ContactControllerTest extends TestBase {
    @MockBean
    private IEmailService emailService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void gegevenJuistEmailRequest_verzendEmail_returnsCreated() throws Exception {
        EmailRequest emailRequest = EmailRequest.builder()
                .verzender("test@email.com")
                .onderwerp("Test")
                .body("Een test vraag over prisma")
                .naam("Test Account")
                .build();

        String jsonEmailRequest = objectMapper.writeValueAsString(emailRequest);
        mockMvc.perform(MockMvcRequestBuilders
                    .post("/contact")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonEmailRequest))
                .andExpect(status().isCreated());

        verify(emailService, times(1)).verzendEmail(emailRequest);
    }

    @Test
    void gegevenOngeldigeEmailRequest_verzendEmail_returnsBadRequest() throws Exception {
        EmailRequest emailRequest = EmailRequest.builder()
                .onderwerp("Test")
                .body("Een test vraag over prisma")
                .naam("Test Account")
                .build();

        String jsonEmailRequest = objectMapper.writeValueAsString(emailRequest);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/contact")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonEmailRequest))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(emailService);
    }

}
