package com.pokemonreview.api.models;

import com.pokemonreview.api.dto.ReviewDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "string")
    private String content;

    @Column(name = "stars")
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    public Review(ReviewDTO reviewDTO) {
        this.id = reviewDTO.getId();
        this.title = reviewDTO.getTitle();
        this.content = reviewDTO.getContent();
        this.stars = reviewDTO.getStars();
    }
}
