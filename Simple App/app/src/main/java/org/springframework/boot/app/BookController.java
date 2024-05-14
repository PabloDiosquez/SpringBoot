package org.springframework.boot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.app.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAll(){
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }
}
