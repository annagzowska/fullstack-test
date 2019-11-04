package com.instantor.dap.springbootbackend.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class StarWarsCharacterResponse {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;
}
