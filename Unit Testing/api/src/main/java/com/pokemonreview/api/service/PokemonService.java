package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDTO;
import com.pokemonreview.api.models.Pokemon;

import java.util.List;

public interface PokemonService {

    PokemonDTO createPokemon(PokemonDTO pokemon);
    PokemonDTO getPokemon(int pokemonId);
    List<PokemonDTO> getPokemons();
    PokemonDTO deletePokemon(int id);
    PokemonDTO updatePokemon(int id, PokemonDTO pokemon);

}
