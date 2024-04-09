package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.exception.EntityNotFoundException;
import com.ltp.gradesubmission.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User getUser(Long id) {
        return unwrapUser(userRepository.findById(id), id);
    }

    @Override
    public User getUser(String username) {
        if(userRepository.existsByUsername(username)){
            return userRepository.findByUsername(username).orElse(null);
        }
        throw new RuntimeException("The user with username '" + username + "' does not exist in our records.");
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public static User unwrapUser(Optional<User> entity, Long id){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new EntityNotFoundException(id, User.class);
    }
}
