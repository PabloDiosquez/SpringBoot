package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.RegisterDTO;
import com.pokemonreview.api.models.Role;
import com.pokemonreview.api.models.UserEntity;
import com.pokemonreview.api.repository.RoleRepository;
import com.pokemonreview.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        try {
            if (userRepository.existsByUsername(registerDTO.getUsername())) {
                return new ResponseEntity<>("Username is already taken.", HttpStatus.BAD_REQUEST);
            }

            UserEntity user = new UserEntity();
            user.setUsername(registerDTO.getUsername());
            user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

            Optional<Role> role = roleRepository.findByName("USER");
            if (role.isPresent()) {
                user.setRoles(Collections.singletonList(role.get()));
            } else {
                throw new IllegalStateException("Something wrong with the role!");
            }

            userRepository.save(user);

            return new ResponseEntity<>("User register success!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error registering user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
