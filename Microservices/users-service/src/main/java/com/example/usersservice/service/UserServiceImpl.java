package com.example.usersservice.service;

import com.example.usersservice.dto.PostDTO;
import com.example.usersservice.dto.UserDTO;
import com.example.usersservice.model.User;
import com.example.usersservice.repository.PostApiClient;
import com.example.usersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private PostApiClient postApiClient;

    @Override
    public UserDTO getUserAndPosts(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return new UserDTO(user.get(), postApiClient.getPostsByUserId(userId));
        }
        throw new RuntimeException("The user does not exists");
    }
}
