package com.instantor.dap.springbootbackend.service;

import com.instantor.dap.springbootbackend.client.SwapiClient;
import com.instantor.dap.springbootbackend.dto.StarWarsCharacterResponse;
import com.instantor.dap.springbootbackend.dto.SwapiFullResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StarWarsCharacterService {

    private final SwapiClient client;

    public StarWarsCharacterResponse getCharacterById(Long id) {
        return SwapiFullResponseMapper.map(client.getCharacterById(id));
    }
}
