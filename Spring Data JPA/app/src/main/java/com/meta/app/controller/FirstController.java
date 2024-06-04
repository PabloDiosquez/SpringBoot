package com.meta.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping(path = "/hi")
    public ResponseEntity<String> sayHi(){
        return new ResponseEntity<>("Hi from my first controller! :)", HttpStatus.OK);
    }

    @GetMapping(path = "/hi-bis")
    @ResponseStatus(HttpStatus.OK)
    public String sayHiBis(){
        return "Hi from my first controller! *)";
    }
}
