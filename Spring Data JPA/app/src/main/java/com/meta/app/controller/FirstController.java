package com.meta.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping(path = "/hi")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> sayHi(){
        return new ResponseEntity<>("Hi from my first controller! :)", HttpStatus.OK);
    }

    @PostMapping(path = "/post")
    public ResponseEntity<String> post(@RequestBody String message){
        return new ResponseEntity<>("Request accepted - Message: " + message, HttpStatus.ACCEPTED);
    }

}
