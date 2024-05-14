package org.springframework.boot.app;

import org.springframework.boot.app.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findByTitle(String title);
}
