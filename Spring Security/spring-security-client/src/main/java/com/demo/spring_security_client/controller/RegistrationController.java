package com.demo.spring_security_client.controller;

import com.demo.spring_security_client.entity.UserEntity;
import com.demo.spring_security_client.model.UserModel;
import com.demo.spring_security_client.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class RegistrationController {
    private UserEntityService userEntityService;
    @PostMapping(path = "/register")
    public String registerUser(@RequestBody UserModel userModel){
        UserEntity user = userEntityService.registerUser(userModel);
        return "The user was created successfully";
    }
}
