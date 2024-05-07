package com.pokemonreview.api.controllers;

import com.pokemonreview.api.models.Pokemon;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/pokemon")
public class PokemonController {

    @GetMapping(path = "/all")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        return null;
    }
}
