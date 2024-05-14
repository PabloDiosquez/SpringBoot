package org.springframework.boot.app.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
}
