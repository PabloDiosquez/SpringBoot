package com.example.userssv.service;

import com.example.userssv.dto.PostDTO;
import com.example.userssv.dto.UserDTO;
import com.example.userssv.model.User;
import com.example.userssv.repository.IUserRepository;
import com.example.userssv.repository.PostAPiClient;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PostAPiClient postAPiClient;

    @Override
    public UserDTO getUserAndPosts(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<PostDTO> posts = postAPiClient.getPostsByUserId(userId);

        assert user != null;
        return new UserDTO(user.getUser_id(), user.getFirstname(), user.getLastname(), posts);
    }
}
