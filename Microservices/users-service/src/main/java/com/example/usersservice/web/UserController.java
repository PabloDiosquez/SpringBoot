package com.example.usersservice.web;

import com.example.usersservice.dto.UserDTO;
import com.example.usersservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    @GetMapping(path = "/posts/{id}")
    public ResponseEntity<UserDTO> getUserAndPosts(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(userService.getUserAndPosts(id), HttpStatus.OK);
    }
}
