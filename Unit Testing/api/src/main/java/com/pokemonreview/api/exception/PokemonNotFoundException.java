package com.pokemonreview.api.exception;

public class PokemonNotFoundException extends RuntimeException{
    public PokemonNotFoundException(String message) {
        super(message);
    }
}
