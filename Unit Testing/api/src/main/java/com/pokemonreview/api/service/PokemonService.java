package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDTO;
import com.pokemonreview.api.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {

    PokemonDTO createPokemon(PokemonDTO pokemon);
    PokemonDTO getPokemon(int pokemonId);
    PokemonResponse getPokemons(int pageNo, int pageSize);
    PokemonDTO deletePokemon(int id);
    PokemonDTO updatePokemon(int id, PokemonDTO pokemon);

}
