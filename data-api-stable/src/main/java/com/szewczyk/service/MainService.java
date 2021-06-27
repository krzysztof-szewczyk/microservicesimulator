package com.szewczyk.service;

import com.szewczyk.domain.MainInformation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

    @Value("${server.port}")
    private String port;

    @SneakyThrows
    public MainInformation getMainInformation() {
        Thread.sleep(200L);
        return new MainInformation("data-api-stable service on port: " + port);
    }
}
