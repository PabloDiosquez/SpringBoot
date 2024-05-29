package com.example.simple_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Mark this class as a REST controller, which allows it to handle HTTP requests
@RestController
public class HelloController {

    @Value("${greeting.message}")
    private String message;

    // Define a route to handle HTTP GET requests at the root path ("/")
    @RequestMapping(path = "/message", method = RequestMethod.GET)
    public String sayHello() {
        // Return a simple greeting message
        return message;
    }

    // Define a route to handle HTTP GET requests at paths like "/{name}"
    @GetMapping(path = "/message/{name}")
    public String sayHello(@PathVariable(name = "name", required = false) String name) {
        // Return a personalized greeting message including the provided name
        return "Hello " + name + "!";
    }
}
