package com.example.userssv.service;

import com.example.userssv.dto.PostDTO;
import com.example.userssv.dto.UserDTO;
import com.example.userssv.model.User;

import java.util.List;

public interface IUserService {
    UserDTO getUserAndPosts(int userId);
}
