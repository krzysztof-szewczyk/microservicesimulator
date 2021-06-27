package com.szewczyk.controller;

import com.szewczyk.domain.MainInformation;
import com.szewczyk.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String blah() {
        System.out.println("ping");
        return "Instance is alive.";
    }

    @GetMapping("/info")
    public ResponseEntity<MainInformation> getMainInfo() {
        System.out.println("/info on port: " + port);
        return ResponseEntity.ok(mainService.getMainInformation());
    }
}