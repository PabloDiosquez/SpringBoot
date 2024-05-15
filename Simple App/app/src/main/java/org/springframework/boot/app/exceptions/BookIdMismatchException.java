package org.springframework.boot.app.exceptions;

public class BookIdMismatchException extends RuntimeException{
    public BookIdMismatchException(String message){
        super(message);
    }
}
