package com.szewczyk.service;

import com.szewczyk.domain.MainInformation;
import com.szewczyk.domain.TransientResponse;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.szewczyk.GatewayApplication.DATA_API_CACHE;
import static java.util.Collections.singletonList;

@Service
@Slf4j
@RequiredArgsConstructor
@RibbonClient(name = "data-api")
public class DataApiService {

    private static final String API_SERVICE = "dataApiService";
    private static final String DATA_API_INFO_URL = "http://data-api/info";

    private final DataApiCache dataApiCache;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(singletonList(MediaType.ALL));
        restTemplate.setMessageConverters(singletonList(converter));
        return restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;

    //TODO: @Bulkhead(name = API_SERVICE)
    //TODO: @RateLimiter(name = API_SERVICE)
    @Retry(name = API_SERVICE, fallbackMethod = "retryFallback")
    @CachePut(value = DATA_API_CACHE)
    public TransientResponse getData(Long time) {
        return new TransientResponse(restTemplate.getForObject(DATA_API_INFO_URL, MainInformation.class), time);
    }

    protected TransientResponse retryFallback(Long time, Exception e) {
        return dataApiCache.retryFallback(time);
    }
}