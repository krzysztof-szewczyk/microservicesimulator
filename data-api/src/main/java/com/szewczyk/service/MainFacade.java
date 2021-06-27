package com.szewczyk.service;

import com.szewczyk.domain.MainInformation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class MainFacade {
    private static final String API_SERVICE = "dataApiService";

    private final MainService mainService;

    @Value("${server.port}")
    private String port;

    @SneakyThrows
//    @TimeLimiter(name = API_SERVICE)
    @CircuitBreaker(name = API_SERVICE)
    public CompletableFuture<MainInformation> getMainInformation() {
        return CompletableFuture.supplyAsync(mainService::getMainInformation);
    }
}
