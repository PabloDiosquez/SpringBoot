package org.springframework.boot.app;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.app.exceptions.BookNotFoundException;
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
    public ResponseEntity<Iterable<Book>> findAll(){
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> findOne(@PathVariable(name = "id") int id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book does not exist"));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(path = "/title/{bookTitle}")
    public ResponseEntity<Book> findByTitle(@PathVariable(name = "bookTitle") String bookTitle){
        return new ResponseEntity<>(bookRepository.findByTitle(bookTitle), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Book> delete(@PathVariable(name = "id") int id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("The book does not exist"));
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable(name = "id") int id){
        Book old = bookRepository.findById(id)
                .orElseThrow();
        return new ResponseEntity<>(bookRepository.save(Book.copy(old, book)), HttpStatus.OK);
    }
}
