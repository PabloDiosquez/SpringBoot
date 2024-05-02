package com.pokemonreview.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String type;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Review> reviews;
}
