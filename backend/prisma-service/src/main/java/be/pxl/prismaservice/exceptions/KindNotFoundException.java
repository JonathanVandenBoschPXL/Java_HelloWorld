package be.pxl.prismaservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class KindNotFoundException extends RuntimeException {
    public static final String MESSAGE = "Het kind werd niet gevonden";

    public KindNotFoundException() {
        super(MESSAGE);
    }
}
