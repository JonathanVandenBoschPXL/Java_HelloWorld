package be.pxl.prismaservice.controllers;

import be.pxl.prismaservice.domain.request.traject.TrajectRequest;
import be.pxl.prismaservice.domain.response.VindTrajectResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectOverzichtResponse;
import be.pxl.prismaservice.domain.response.traject.TrajectResponse;
import be.pxl.prismaservice.services.ITrajectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/traject/")
@RequiredArgsConstructor
public class TrajectController {
    private final ITrajectService trajectService;

    @GetMapping("{userId}/kind/{kindId}")
    public ResponseEntity<VindTrajectResponse> getTrajectPerKindPerUser(@PathVariable @Validated Long userId, @PathVariable @Validated Long kindId){
        log.info("GET: check of er voor user met userId {} een traject bestaat voor kind met kindID {}",
                userId, kindId);
        return new ResponseEntity<>(trajectService.vindTrajectPerKindPerUser(userId, kindId), HttpStatus.OK);
    }

    @PostMapping("{userId}/kind/{kindId}")
    public ResponseEntity<TrajectOverzichtResponse> voegTrajectToeAanKindEnUser(@PathVariable @Validated Long userId, @PathVariable @Validated Long kindId, @RequestBody TrajectRequest trajectRequest){
        log.info("POST: voeg traject van user met userId {} toe aan trajecten van kind met kindId {}", userId, kindId);
        return new ResponseEntity<>(trajectService.voegTrajectToeAanKindEnUser(userId, kindId, trajectRequest), HttpStatus.OK);
    }

    @GetMapping("{userId}/kind/{kindId}/traject")
    public ResponseEntity<List<TrajectResponse>> getTraject(@PathVariable @Validated Long userId, @PathVariable @Validated Long kindId){
        log.info("GET: verkrijg traject van kind met kindId {} voor user met userId {}", kindId, userId);
        return new ResponseEntity<>(trajectService.vindTraject(userId, kindId), HttpStatus.OK);
    }
    @GetMapping("recentTraject/{recentTrajectId}/kind/{kindId}/allTrajecten")
    public ResponseEntity<List<TrajectResponse>> vindAlleTrajectenVanKindBehalveMeestRecent(@PathVariable @Validated Long kindId, @PathVariable @Validated Long recentTrajectId){
        log.info("GET: verkrijg al de trajecten van kind {}", kindId);
        return new ResponseEntity<>(trajectService.vindAlleTrajectenVanKindBehalveMeestRecent(kindId, recentTrajectId) ,HttpStatus.OK);
    }
    @GetMapping("/kind/{kindId}/allTrajecten")
    public ResponseEntity<List<TrajectResponse>> vindAlleTrajectenVanKindB(@PathVariable @Validated Long kindId){
        log.info("GET: verkrijg al de trajecten van kind {}", kindId);
        return new ResponseEntity<>(trajectService.vindAlleTrajectenVanKind(kindId) ,HttpStatus.OK);
    }
}
