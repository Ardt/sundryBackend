package com.ardt.sundry.dao;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.model.Review;

public interface ReviewDao {

    // Create Review
    public void insertReview(Review review);

    public void updateReview(Review review);
    
    // Read Review
    public List<Review> findAll();

    // Read Review
    public Optional<Review> findById(String id);

    // Delete Review
    public void deleteById(String id);
}
