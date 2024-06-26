package com.pokemonreview.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<ErrorObject> handlePokemonNotFoundException(PokemonNotFoundException ex, WebRequest request){
        ErrorObject error = new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
