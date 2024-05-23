package com.demo.spring_security_client.controller;

import com.demo.spring_security_client.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class UserEntityController {
    private UserEntityService userEntityService;
}
