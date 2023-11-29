package com.example.vinofind.repository;

import com.example.vinofind.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
    public List<Review> findAllByWineryId (Long wineryId);


}
