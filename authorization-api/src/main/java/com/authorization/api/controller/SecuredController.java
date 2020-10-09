package com.authorization.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecuredController {

    @GetMapping
    public ResponseEntity secured() {
        return new ResponseEntity("Eres un usuario autenticado!", HttpStatus.OK);
    }
}
