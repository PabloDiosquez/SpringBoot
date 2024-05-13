package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.ReviewDTO;
import com.pokemonreview.api.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/pokemon/{pokemonId}/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(name = "pokemonId") int pokemonId,
                                                  @RequestBody ReviewDTO reviewDTO){
        return new ResponseEntity<>(reviewService.createReview(pokemonId, reviewDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getReviewsByPokemonId(@PathVariable(name = "pokemonId") int pokemonId){
        return new ResponseEntity<>(reviewService.getReviewsByPokemonId(pokemonId), HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable(name = "pokemonId") int pokemonId,
                                                   @PathVariable(name = "id") int id){
        return new ResponseEntity<>(reviewService.getReviewById(id, pokemonId), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable(name = "pokemonId") int pokemonId,
                                                  @PathVariable(name = "id") int id,
                                                  @RequestBody ReviewDTO reviewDTO){
        return new ResponseEntity<>(reviewService.updateReview(pokemonId, id, reviewDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "/id")
    public ResponseEntity<ReviewDTO> deleteReview(@PathVariable(name = "pokemonId") int pokemonId,
                                                  @PathVariable(name = "id") int id){
        return new ResponseEntity<>(reviewService.deleteReview(pokemonId, id), HttpStatus.OK);
    }
}
