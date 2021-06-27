package com.szewczyk.service;

import com.szewczyk.GatewayApplication;
import com.szewczyk.domain.MainInformation;
import com.szewczyk.domain.TransientResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class DataApiCache {

    @Cacheable(value = GatewayApplication.DATA_API_CACHE, key = GatewayApplication.DATA_API_CACHE_KEY)
    public TransientResponse retryFallback(Long time) {
        return new TransientResponse(new MainInformation("Sorry, the service is unreachable."), time);
    }
}