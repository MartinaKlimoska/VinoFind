package com.example.vinofind.service;

import com.example.vinofind.model.Review;
import com.example.vinofind.model.Winery;
import com.example.vinofind.repository.ReviewsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewsServiceTest {

    @Mock
    private ReviewsRepository reviewsRepository;

    @InjectMocks
    private ReviewsService reviewsService;

    @Test
    public void testGetReviewsForWinery() {
        // Mock data
        Winery winery = new Winery();
        winery.setId(1L);

        Review review1 = new Review();
        review1.setId(1L);
        review1.setWineryId(1L);

        Review review2 = new Review();
        review2.setId(2L);
        review2.setWineryId(1L);

        List<Review> mockReviews = Arrays.asList(review1, review2);

        // Mock repository behavior
        when(reviewsRepository.findAllByWineryId(winery.getId())).thenReturn(mockReviews);

        // Test the service method
        List<Review> result = reviewsService.getReviewsForWinery(winery);

        // Assertions
        assertEquals(mockReviews, result);
    }

    @Test
    public void testCreateReview() {
        // Mock data
        Review newReview = new Review();
        newReview.setId(1L);

        // Mock repository behavior
        when(reviewsRepository.save(Mockito.any(Review.class))).thenReturn(newReview);

        // Test the service method
        Review result = reviewsService.createReview(newReview);

        // Assertions
        assertEquals(newReview, result);
    }

    @Test
    public void testGetReviewById() {
        // Mock data
        Long reviewId = 1L;
        Review mockReview = new Review();
        mockReview.setId(reviewId);

        // Mock repository behavior
        when(reviewsRepository.findById(reviewId)).thenReturn(Optional.of(mockReview));

        // Test the service method
        Optional<Review> result = reviewsService.getReviewById(reviewId);

        // Assertions
        assertEquals(Optional.of(mockReview), result);
    }

    @Test
    public void testUpdateReview() {
        // Mock data
        Review updatedReview = new Review();
        updatedReview.setId(1L);

        // Mock repository behavior
        when(reviewsRepository.save(Mockito.any(Review.class))).thenReturn(updatedReview);

        // Test the service method
        Review result = reviewsService.updateReview(updatedReview);

        // Assertions
        assertEquals(updatedReview, result);
    }

    @Test
    public void testDeleteReview() {
        // Mock data
        Review reviewToDelete = new Review();
        reviewToDelete.setId(1L);

        // Test the service method
        reviewsService.deleteReview(reviewToDelete);

        // Verify that the save method was called
        Mockito.verify(reviewsRepository).save(reviewToDelete);
    }
}
