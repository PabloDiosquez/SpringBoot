package com.lpt.contactsspringsecurity.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@Getter @Setter
public class Contact {
    private String id;

    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @NotBlank(message = "Phone number cannot be blank.")
    private String phoneNumber;

    public Contact(){
        this.id = UUID.randomUUID().toString();
    }

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
