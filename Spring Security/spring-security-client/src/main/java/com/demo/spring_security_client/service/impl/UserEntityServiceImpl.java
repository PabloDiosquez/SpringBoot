package com.demo.spring_security_client.service.impl;

import com.demo.spring_security_client.repository.UserRepository;
import com.demo.spring_security_client.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserEntityServiceImpl implements UserEntityService {
    private UserRepository userRepository;
}
