package com.demo.spring_security_client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String matchingPassword;
}
