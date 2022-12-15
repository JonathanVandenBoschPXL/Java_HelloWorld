package be.pxl.prismaservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public static final String MESSAGE = "De gebruiker werd niet gevonden";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
