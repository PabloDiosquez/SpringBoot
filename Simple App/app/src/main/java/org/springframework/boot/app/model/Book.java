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

    public static Book copy(Book old, Book current){
        old.setTitle(current.getTitle());
        old.setAuthor(current.getAuthor());
        return old;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
