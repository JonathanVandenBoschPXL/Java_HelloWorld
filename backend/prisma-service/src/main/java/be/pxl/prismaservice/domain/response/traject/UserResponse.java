package be.pxl.prismaservice.domain.response.traject;

import be.pxl.prismaservice.domain.UserRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UserRol rol;
}
