package com.instantor.dap.springbootbackend.client;

import com.instantor.dap.springbootbackend.dto.SwapiFullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SwapiClient {

    private final RestTemplate defaultRestTemplate;

    @Value("${swapi.url}")
    private String swapiUrl;

    public SwapiFullResponse getCharacterById(Long id) {
        String url = swapiUrl + "/people/" + id.toString();
        return defaultRestTemplate.getForEntity(url, SwapiFullResponse.class, id).getBody();
    }
}
