package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.domain.response.KindOverzicht;
import be.pxl.prismaservice.services.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("{userId}/kinderen")
    public ResponseEntity<List<KindOverzicht>> getOverzichtKinderen(@PathVariable @Validated Long userId){
        log.info("GET: overzicht kinderen van gebruiker met id {}",
                userId);
        return new ResponseEntity<>(userService.vindAlleKinderenMetUserId(userId), HttpStatus.OK);
    }
}
