package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.ReviewDTO;
import java.util.List;

public interface ReviewService {

    ReviewDTO getReview(int id);
    ReviewDTO createReview(ReviewDTO reviewDTO);
    List<ReviewDTO> getReviews();
    ReviewDTO deleteReview(int id);
    ReviewDTO updateReview(int id, ReviewDTO review);
}
