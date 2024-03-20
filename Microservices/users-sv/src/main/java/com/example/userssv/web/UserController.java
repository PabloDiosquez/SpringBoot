package com.example.userssv.web;

import com.example.userssv.dto.PostDTO;
import com.example.userssv.dto.UserDTO;
import com.example.userssv.model.User;
import com.example.userssv.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/posts/{userId}")
    public UserDTO getUserAndPosts(@PathVariable(name = "userId") int userId){
        return userService.getUserAndPosts(userId);
    }

}
