package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.PokemonDTO;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/pokemon")
public class PokemonController {

    private PokemonService pokemonService;
    @GetMapping(path = "/all")
    public ResponseEntity<PokemonResponse> getPokemons(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                       @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        return ResponseEntity.ok(pokemonService.getPokemons(pageNo, pageSize));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PokemonDTO> pokemonDetail(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(pokemonService.getPokemon(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PokemonDTO> createPokemon(@RequestBody PokemonDTO pokemon){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemon), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<PokemonDTO> deletePokemon(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(pokemonService.deletePokemon(id), HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable(name = "id") int id,
                                                    @RequestBody PokemonDTO pokemonDto){
        return new ResponseEntity<>(pokemonService.updatePokemon(id, pokemonDto), HttpStatus.OK);
    }
}
