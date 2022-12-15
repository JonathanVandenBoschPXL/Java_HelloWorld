package be.pxl.prismaservice.services;

import java.util.List;

public interface ITokenService {
    String getToken(String email, String wachtwoord) throws Exception;
    List<Integer> getClaimKinderen();
}
