package com.example.usersservice.dto;

import com.example.usersservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDTO {
    private int id;
    private String name;
    private String lastName;
    private String cellphone;
    private List<PostDTO> posts;
}
