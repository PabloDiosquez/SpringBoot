package com.example.userssv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDTO {
    private int user_id;
    private String firstname;
    private String lastname;
    private List<PostDTO> posts;
}
