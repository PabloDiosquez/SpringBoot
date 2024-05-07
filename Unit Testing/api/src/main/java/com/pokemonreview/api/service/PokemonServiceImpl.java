package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDTO;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PokemonServiceImpl implements PokemonService{
    private PokemonRepository pokemonRepository;

    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemonDto) {
        Pokemon pokemon = pokemonRepository.save(new Pokemon(pokemonDto.getName(), pokemonDto.getType()));
        return new PokemonDTO(pokemon);
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

    private Pokemon unwrapPokemon(Optional<Pokemon> entity, int id){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException("The pokemon with id '" + id + "' does not exist in our records.");
    }
}
