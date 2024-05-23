package com.demo.spring_security_client.service;

import com.demo.spring_security_client.entity.UserEntity;
import com.demo.spring_security_client.model.UserModel;

public interface UserEntityService {
    UserEntity registerUser(UserModel userModel);
}
