package com.pokemonreview.api.dto;

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
}
