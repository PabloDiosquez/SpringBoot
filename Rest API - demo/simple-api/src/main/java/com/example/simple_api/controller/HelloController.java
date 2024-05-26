package com.example.simple_api.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello!";
    }

    @GetMapping(path = "/{name}")
    public String sayHello(@PathVariable(name = "name", required = false) String name){
        return "Hello " + name + "!";
    }
}
