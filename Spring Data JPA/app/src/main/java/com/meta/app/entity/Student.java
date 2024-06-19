package com.meta.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"last-name", "email-address"})
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first-name", nullable = false, length = 25)
    private String firstname;

    @Column(name = "last-name", nullable = false, length = 50)
    private String lastname;

    @Column(name = "email-address", length = 100)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "date-of-birth")
    private LocalDate dateOfBirth;
}
