package com.api.pokeapi.repository;

import com.api.pokeapi.dto.PokemonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "poke-api", url = "https://pokeapi.co/api/v2")
public interface PokeAPIClient {
    @GetMapping("/pokemon/{pokemonId}")
    public PokemonDTO getPokemonData(@PathVariable(name = "pokemonId") int pokemonId);
}
