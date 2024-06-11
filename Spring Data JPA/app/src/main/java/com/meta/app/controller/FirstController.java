package com.meta.app.controller;

import com.meta.app.entity.Order;
import com.meta.app.entity.OrderRecord;
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
    @PostMapping(path = "/post-order")
    public ResponseEntity<String> postOrder(@RequestBody Order order){
        return new ResponseEntity<>("Request accepted - Order: " + order, HttpStatus.CREATED);
    }

    @PostMapping(path = "/post-order-record")
    public ResponseEntity<String> postRecorde(@RequestBody OrderRecord orderRecord){
        return new ResponseEntity<>(orderRecord.toString(), HttpStatus.OK);
    }

    @GetMapping(path = "/hi/{user-name}")
    public ResponseEntity<String> sayHi(@PathVariable(name = "user-name") String userName){
        return new ResponseEntity<>("Hi " + userName + "! :)", HttpStatus.OK);
    }
    @GetMapping(path = "/hi/user")
    public ResponseEntity<String> sayHiParam(@RequestParam(name = "user-name") String userName){
        return new ResponseEntity<>("Hi " + userName + "! :)", HttpStatus.OK);
    }

}
