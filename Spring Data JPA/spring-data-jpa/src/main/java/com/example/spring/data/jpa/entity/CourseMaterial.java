package com.example.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "course_materials")
public class CourseMaterial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_seq"
    )
    @SequenceGenerator(
            name = "course_material_seq",
            sequenceName = "course_material_seq",
            allocationSize = 1
    )
    private int id;

    @Column(name = "course_url", nullable = false, unique = true)
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id"
    )
    private Course course;

}
