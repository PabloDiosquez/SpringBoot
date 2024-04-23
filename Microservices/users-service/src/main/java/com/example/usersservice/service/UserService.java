package com.example.usersservice.service;

import com.example.usersservice.dto.UserDTO;

public interface UserService {

    public UserDTO getUserAndPosts(int userId);
}
