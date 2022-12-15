package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.domain.response.KindProfile;
import be.pxl.prismaservice.services.IKindService;
import be.pxl.prismaservice.services.impl.TokenServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/kind")
@RequiredArgsConstructor
public class KindController {
    private final IKindService kindService;
    private final TokenServiceImpl tokenService;

    @GetMapping("/{id}")
    public ResponseEntity<KindProfile> getKindById(@PathVariable @Validated String id) {
        log.info("GET: opvragen van kind met id {}",id);
        List<Integer> kindIds = tokenService.getClaimKinderen();
        log.info("Ingelogde gebruiker heeft toegang tot kinderen met id {}", kindIds);
        if(kindIds.contains(Integer.parseInt(id))){
            return new ResponseEntity<>(kindService.getById(Long.parseLong(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
