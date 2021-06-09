package com.example.beerclient.web.client;

import com.example.beerclient.web.model.BrewDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sasi.brewery", ignoreUnknownFields =false)
public class BreweryClient {
    public final String BEER_PATH_V1="/api/v1/beer/";
    public String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public BrewDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+beerId.toString(), BrewDto.class);
    }
    public URI saveBeer(BrewDto brewDto){
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1,brewDto);
    }
    public void updateBeer(BrewDto brewDto){
         restTemplate.put(apiHost+BEER_PATH_V1+brewDto.getId(),brewDto);
    }
    public void deleteBeer(BrewDto brewDto){
        restTemplate.delete(apiHost+BEER_PATH_V1+brewDto.getId());
    }
    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }
}
