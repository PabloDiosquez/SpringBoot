package com.pokemonreview.api.controllers;

import com.pokemonreview.api.models.Pokemon;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/pokemon")
public class PokemonController {

    @GetMapping(path = "/all")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(null);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable(name = "id") int id,
                                                 @RequestBody Pokemon pokemon){
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }
}
