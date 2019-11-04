package com.instantor.dap.springbootbackend.controller;

import com.instantor.dap.springbootbackend.service.StarWarsCharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.instantor.dap.springbootbackend.controller.BaseResponse.errorMessageResponse;
import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isEmpty;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/sw")
public class StarWarsCharacterController {

    private final StarWarsCharacterService service;

    /**
     * @return character from Star Wars
     */
    @GetMapping("/character/{id}")
    public ResponseEntity getCharacter(@PathVariable("id") Long id) {
        if (isNull(id)) {
            return errorMessageResponse("Missing parameters", BAD_REQUEST);
        }
        return new ResponseEntity(service.getCharacterById(id), OK);
    }
}
