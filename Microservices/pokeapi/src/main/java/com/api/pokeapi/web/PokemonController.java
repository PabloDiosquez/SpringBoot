package com.api.pokeapi.web;

import com.api.pokeapi.dto.PokemonDTO;
import com.api.pokeapi.repository.PokeAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    @Autowired
    private PokeAPIClient pokeAPIClient;

    @GetMapping(path = "pokemon/{pokemonId}")
    public PokemonDTO getPokemonData(@PathVariable(name = "pokemonId") int pokemonId){
        return pokeAPIClient.getPokemonData(pokemonId);
    }
}
