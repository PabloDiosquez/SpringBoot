package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDTO;
import com.pokemonreview.api.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PokemonServiceImpl implements PokemonService{
    private PokemonRepository pokemonRepository;

    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemon) {
        return null;
    }

    @Override
    public PokemonDTO getPokemon(int pokemonId) {
        return null;
    }

    @Override
    public List<PokemonDTO> getPokemons() {
        return null;
    }

    @Override
    public PokemonDTO deletePokemon(int id) {
        return null;
    }

    @Override
    public PokemonDTO updatePokemon(int id, PokemonDTO pokemon) {
        return null;
    }
}
