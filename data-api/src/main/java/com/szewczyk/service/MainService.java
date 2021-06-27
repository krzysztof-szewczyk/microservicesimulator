package com.szewczyk.service;

import com.szewczyk.domain.MainInformation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class MainService {
    private static final String API_SERVICE = "dataApiService";

    @Value("${server.port}")
    private String port;

    @SneakyThrows
    public MainInformation getMainInformation() {
        sleep(200);
        return new MainInformation("data-api service on port: " + port);
    }
}
