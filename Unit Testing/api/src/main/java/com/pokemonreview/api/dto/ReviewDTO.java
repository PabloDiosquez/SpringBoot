package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDTO {
    private int id;
    private String title;
    private String content;
    private int stars;
    private Pokemon pokemon;
}
