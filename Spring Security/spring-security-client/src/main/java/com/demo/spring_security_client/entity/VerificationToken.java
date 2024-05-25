package com.demo.spring_security_client.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
@Data
@Entity
public class VerificationToken {
    public static final int EXPIRATION_TIME = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String token;

    private Date expiration;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "KF_USER_VERIFY_TOKEN")
    )
    private UserEntity user;

    public VerificationToken(String token, UserEntity user) {
        this.user = user;
        this.token = token;
        this.expiration = calculateExpirationDate(EXPIRATION_TIME);
    }

    private Date calculateExpirationDate(int expirationTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
