package com.demo.spring_security_client.service.impl;

import com.demo.spring_security_client.entity.UserEntity;
import com.demo.spring_security_client.model.UserModel;
import com.demo.spring_security_client.repository.UserEntityRepository;
import com.demo.spring_security_client.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserEntityServiceImpl implements UserEntityService {
    private UserEntityRepository userRepository;

    @Override
    public UserEntity registerUser(UserModel userModel) {
        UserEntity user = UserEntity.builder()
                .firstname(userModel.getFirstname())
                .lastname(userModel.getLastname())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .build();


        return null;
    }
}
