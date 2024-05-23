package com.demo.spring_security_client.service.impl;

import com.demo.spring_security_client.entity.UserEntity;
import com.demo.spring_security_client.model.UserModel;
import com.demo.spring_security_client.repository.UserEntityRepository;
import com.demo.spring_security_client.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserEntityServiceImpl implements UserEntityService {
    private UserEntityRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity registerUser(UserModel userModel) {
        UserEntity user = UserEntity.builder()
                .firstname(userModel.getFirstname())
                .lastname(userModel.getLastname())
                .email(userModel.getEmail())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .role("USER")
                .build();

        return userRepository.save(user);
    }
}
