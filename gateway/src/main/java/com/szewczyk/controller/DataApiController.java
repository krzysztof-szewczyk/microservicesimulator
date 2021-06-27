package com.szewczyk.controller;

import com.szewczyk.domain.TransientResponse;
import com.szewczyk.domain.GatewayResponse;
import com.szewczyk.service.DataApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DataApiController {

    @Autowired
    private DataApiService dataApiService;

    @GetMapping("/start")
    public ResponseEntity<GatewayResponse> getData() {
        long time = System.currentTimeMillis();
        TransientResponse response = dataApiService.getData(time);
        return ResponseEntity.ok(
                new GatewayResponse(
                        response.getMainInformation(),
                        time > response.getTime(),
                        new Date(time),
                        new Date(response.getTime())
                )
        );
    }
}
