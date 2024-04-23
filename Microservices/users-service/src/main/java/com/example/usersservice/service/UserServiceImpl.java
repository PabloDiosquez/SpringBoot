package com.example.usersservice.service;

import com.example.usersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
}
