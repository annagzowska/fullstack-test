package com.instantor.dap.springbootbackend.dto;

public class SwapiFullResponseMapper {

    public static StarWarsCharacterResponse map(SwapiFullResponse swapiResponse) {
        return StarWarsCharacterResponse.builder()
                .name(swapiResponse.getName())
                .height(swapiResponse.getHeight())
                .mass(swapiResponse.getMass())
                .hairColor(swapiResponse.getHair_color())
                .skinColor(swapiResponse.getSkin_color())
                .eyeColor(swapiResponse.getEye_color())
                .birthYear(swapiResponse.getBirth_year())
                .gender(swapiResponse.getGender())
                .homeworld(swapiResponse.getHomeworld())
                .films(swapiResponse.getFilms())
                .species(swapiResponse.getSpecies())
                .vehicles(swapiResponse.getVehicles())
                .starships(swapiResponse.getStarships())
                .created(swapiResponse.getCreated())
                .edited(swapiResponse.getEdited())
                .url(swapiResponse.getUrl())
                .build();
    }
}
