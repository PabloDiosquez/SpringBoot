package com.spring.springdatajpatutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "email",
                columnNames = "email_address"
        )

)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int studentId;
    private String firstname;
    private String lastname;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;
    @Embedded
    private Guardian guardian;
}
