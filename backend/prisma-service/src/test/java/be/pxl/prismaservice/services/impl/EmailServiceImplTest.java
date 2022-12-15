package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.TestBase;
import be.pxl.prismaservice.domain.request.EmailRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceImplTest extends TestBase {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailServiceImpl emailService;

    @Test
    void gegevenValidEmailRequest_verzendEmail_verstuurtEmailViaMailSender() {
        EmailRequest emailRequest = EmailRequest
                .builder()
                .verzender("email@test.com")
                .body("testbody")
                .onderwerp("testonderwerp")
                .build();

            emailService.verzendEmail(emailRequest);
            verify(mailSender, times(1)).send(any(MimeMessagePreparator.class));
    }

    @Test
    void gegevenProbleemMetMailSender_verzendEmail_vangtMailExceptionOp() {
        //We moeten hier een MailParseException gooien, of een andere subklasse van MailException
        //omdat MailException een abstracte klasse is
        doThrow(MailParseException.class).when(mailSender).send(any(MimeMessagePreparator.class));
        emailService.verzendEmail(EmailRequest.builder().build());
        verify(mailSender, times(1)).send(any(MimeMessagePreparator.class));
    }
}