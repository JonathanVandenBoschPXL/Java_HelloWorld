package be.pxl.prismaservice.services.impl;

import be.pxl.prismaservice.domain.request.EmailRequest;
import be.pxl.prismaservice.services.IEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableAsync
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender mailSender;

    public static final String ONTVANGER = "info@prismaproject.be";
    public static final String ONDERWERP_PREFIX = "Bericht vanuit PRISMA: ";

    @Override
    @Async
    public void verzendEmail(EmailRequest emailRequest) {
        MimeMessagePreparator mailMessage = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setFrom(emailRequest.getVerzender(), emailRequest.getNaam());
            message.setTo(ONTVANGER);
            message.setSubject(ONDERWERP_PREFIX + emailRequest.getOnderwerp());
            message.setText(emailRequest.getBody());
        };
        try {
            mailSender.send(mailMessage);
            log.info("Mail verzonden!");
        } catch (MailException ex) {
            log.error("Mail niet verzonden: {}", ex.getMessage());
        }
    }
}
