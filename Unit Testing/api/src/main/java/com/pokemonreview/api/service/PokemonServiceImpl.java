package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDTO;
import com.pokemonreview.api.exception.PokemonNotFoundException;
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
        return mapToDTO(pokemon);
    }

    @Override
    public PokemonDTO getPokemon(int id) {
        return mapToDTO(unwrapPokemon(pokemonRepository.findById(id), id));
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public PokemonDTO deletePokemon(int id) {
        Pokemon pokemon = unwrapPokemon(pokemonRepository.findById(id), id);
        pokemonRepository.deleteById(id);
        return mapToDTO(pokemon);
    }

    @Override
    public PokemonDTO updatePokemon(int id, PokemonDTO pokemonDto) {
        Pokemon pokemon = unwrapPokemon(pokemonRepository.findById(id), id);
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        pokemonRepository.save(pokemon);
        return mapToDTO(pokemon);
    }

    private Pokemon unwrapPokemon(Optional<Pokemon> entity, int id){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new PokemonNotFoundException("The pokemon with id '" + id + "' does not exist in our records.");
    }

    private PokemonDTO mapToDTO(Pokemon pokemon){
        return new PokemonDTO(pokemon);
    }
}
