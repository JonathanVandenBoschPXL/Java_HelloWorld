package be.pxl.prismaservice.domain.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class EmailRequest {
    @NotBlank
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    String verzender;
    @NotBlank
    String onderwerp;
    @NotBlank
    String body;
    @NotBlank
    String naam;
}
