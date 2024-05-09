package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.ReviewDTO;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.exception.ReviewNotFoundException;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.models.Review;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.repository.ReviewRepository;
import com.pokemonreview.api.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private PokemonRepository pokemonRepository;

    @Override
    public ReviewDTO createReview(int pokemonId, ReviewDTO reviewDto) {
        Review review = mapToEntity(reviewDto);
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("The pokemon with id '" + pokemonId + "' does not exist in our records"));
        review.setPokemon(pokemon);
        reviewRepository.save(review);
        return mapToDTO(review);
    }

    @Override
    public List<ReviewDTO> getReviewsByPokemonId(int id) {
        List<Review> reviews = reviewRepository.findByPokemonId(id);
        return reviews.stream().map(review -> mapToDTO(review)).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(int reviewId, int pokemonId) {
        return unwrapReview(reviewRepository.findById(reviewId), reviewId, pokemonId);
    }

    @Override
    public ReviewDTO updateReview(int pokemonId, int reviewId, ReviewDTO reviewDTO) {
        ReviewDTO old = getReviewById(reviewId, pokemonId);
        return ReviewDTO.copy(old, reviewDTO);
    }

    @Override
    public ReviewDTO deleteReview(int pokemonId, int reviewId) {
        ReviewDTO reviewDTO = getReviewById(reviewId, pokemonId);
        reviewRepository.deleteById(reviewId);
        return reviewDTO;
    }

    private ReviewDTO unwrapReview(Optional<Review> entity, int reviewId, int pokemonId){
        if(entity.isPresent()){
            if(entity.get().getPokemon().getId() != pokemonId){
                throw new ReviewNotFoundException("This review does not belong to a pokemon");
            }
            return mapToDTO(entity.get());
        }
        throw new ReviewNotFoundException("The review with id '" + reviewId + "' does not exist in our records");
    }

    private ReviewDTO mapToDTO(Review review){
        return new ReviewDTO(review);
    }

    private Review mapToEntity(ReviewDTO reviewDTO){
        return new Review(reviewDTO);
    }
}
