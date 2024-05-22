package com.example.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "courses")
@ToString(exclude = "courseMaterial")
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "credit")
    private int credit;

    @OneToOne(
            mappedBy = "course",
            fetch = FetchType.EAGER,
            optional = false
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacher;

}
