package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.domain.request.LoginRequest;
import be.pxl.prismaservice.services.ITokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController{
    private final ITokenService tokenService;

    @PostMapping
    @RolesAllowed("user")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) throws Exception{
        return new ResponseEntity<>(tokenService.getToken(request.getEmail(), request.getWachtwoord()), HttpStatus.OK);
    }
}
