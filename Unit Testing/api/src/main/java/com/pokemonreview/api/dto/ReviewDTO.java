package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.models.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReviewDTO {
    private int id;
    private String title;
    private String content;
    private int stars;

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.stars = review.getStars();
    }
}
