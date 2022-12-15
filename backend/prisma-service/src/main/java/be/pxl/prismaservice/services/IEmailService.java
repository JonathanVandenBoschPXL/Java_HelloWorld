package be.pxl.prismaservice.services;

import be.pxl.prismaservice.domain.request.EmailRequest;

public interface IEmailService {

    void verzendEmail(EmailRequest emailRequest);
}
