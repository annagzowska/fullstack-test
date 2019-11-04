package com.instantor.dap.springbootbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseResponse {

    static ResponseEntity errorMessageResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}
