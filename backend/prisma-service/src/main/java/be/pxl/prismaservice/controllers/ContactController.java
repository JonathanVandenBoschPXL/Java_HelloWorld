package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.domain.request.EmailRequest;
import be.pxl.prismaservice.services.IEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final IEmailService emailService;

    @PostMapping
    public ResponseEntity<HttpStatus> verzendEmail(@Valid @RequestBody EmailRequest emailRequest) {
        log.info("POST: Email verzenden van: {}", emailRequest.getVerzender());
        emailService.verzendEmail(emailRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
