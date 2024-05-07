package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PokemonDTO {
    private int id;
    private String name;
    private String type;

    public PokemonDTO(Pokemon pokemon) {
        id = pokemon.getId();
        name = pokemon.getName();
        type = pokemon.getType();
    }
}
