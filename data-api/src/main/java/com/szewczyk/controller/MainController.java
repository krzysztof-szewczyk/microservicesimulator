package com.szewczyk.controller;

import com.szewczyk.domain.MainInformation;
import com.szewczyk.service.MainFacade;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainFacade mainFacade;

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String blah() {
        System.out.println("ping");
        return "Instance is alive.";
    }

    @SneakyThrows
    @GetMapping("/info")
    @CircuitBreaker(name = "default")
    public ResponseEntity<MainInformation> getMainInfo() {
        System.out.println("/info on port: " + port);
        return ResponseEntity.ok(mainFacade.getMainInformation().get());
    }
}
