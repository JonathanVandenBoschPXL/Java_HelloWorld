package be.pxl.prismaservice.domain.request;

public class LoginRequest {
    private String email;
    private String wachtwoord;

    public LoginRequest(String username, String password) {
        this.email = username;
        this.wachtwoord = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
