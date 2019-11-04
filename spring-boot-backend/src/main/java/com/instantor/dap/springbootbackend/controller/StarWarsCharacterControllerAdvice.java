package com.instantor.dap.springbootbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

import static com.instantor.dap.springbootbackend.controller.BaseResponse.errorMessageResponse;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class StarWarsCharacterControllerAdvice {

    @ExceptionHandler({HttpStatusCodeException.class})
    public ResponseEntity handleHttpStatusCodeException(HttpStatusCodeException ex) {
        log.warn("Something went wrong while requesting Swapi. Message: " + ex.getLocalizedMessage());
        return errorMessageResponse(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleAnyException(Exception ex) {
        log.error(ex.toString());
        return errorMessageResponse("Something very unexpected has happened.", INTERNAL_SERVER_ERROR);
    }
}
