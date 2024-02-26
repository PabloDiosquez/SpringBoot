package com.example.javagram;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
public class User {
    @NotBlank(message="First name cannot be blank")
    @Size(min=2, message="First name is too short")
    private String firstname;
    @NotBlank(message="Last name cannot be blank")
    @Size(min=2, message="Last name is too short")
    private String lastname;
    @NotBlank(message="Username cannot be blank" )
    @Size(min=7, message="Username is too short")
    private String username;
    @Email(message="Invalid email")
    private String email;
    @Past(message="Date of birth must be in the past")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    public User() {

    }
    public User(String firstname, String lastname, String username, String email, Date dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
