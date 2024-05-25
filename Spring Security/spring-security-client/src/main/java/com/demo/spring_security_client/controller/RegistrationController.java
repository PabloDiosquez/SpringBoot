package com.demo.spring_security_client.controller;

import com.demo.spring_security_client.entity.UserEntity;
import com.demo.spring_security_client.event.RegistrationCompleteEvent;
import com.demo.spring_security_client.model.UserModel;
import com.demo.spring_security_client.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class RegistrationController {
    private UserEntityService userEntityService;

    private ApplicationEventPublisher publisher;
    @PostMapping(path = "/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserModel userModel){
        UserEntity user = userEntityService.registerUser(userModel);
        publisher.publishEvent(
                RegistrationCompleteEvent.builder()
                .user(user)
                .applicationUrl("url")
                .build()
        );
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
