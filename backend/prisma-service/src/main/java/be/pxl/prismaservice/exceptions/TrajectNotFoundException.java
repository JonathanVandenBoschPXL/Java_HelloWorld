package be.pxl.prismaservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TrajectNotFoundException extends RuntimeException{
    public static final String MESSAGE = "Er werd geen traject gevonden voor deze gebruiker";

    public TrajectNotFoundException() {
        super(MESSAGE);
    }
}
