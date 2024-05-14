package com.example.config;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Version version;

    public UserService(Version version){
        this.version = version;
    }
}
