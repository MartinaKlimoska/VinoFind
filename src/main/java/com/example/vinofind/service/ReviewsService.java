package com.example.vinofind.service;

import com.example.vinofind.model.Review;
import com.example.vinofind.model.Winery;
import com.example.vinofind.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public List<Review> getReviewsForWinery(Winery winery){
        return reviewsRepository.findAllByWineryId(winery.getId());
    }

    public Review createReview(Review review) {
        return reviewsRepository.save(review);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewsRepository.findById(id);
    }

    public Review updateReview(Review updatedReview) {
        updatedReview.update();
        return reviewsRepository.save(updatedReview);
    }

    public void deleteReview(Review review) {
        review.delete();
        reviewsRepository.save(review);
    }
}
