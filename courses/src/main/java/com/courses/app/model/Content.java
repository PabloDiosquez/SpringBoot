package com.courses.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idContent;
    private String contentName;
    private String description;
    @ManyToOne
    @JoinColumn(name="idCourse")
    private Course course;
}
