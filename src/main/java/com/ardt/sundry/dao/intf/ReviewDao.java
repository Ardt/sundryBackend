package com.ardt.sundry.dao.intf;

import java.util.List;

import com.ardt.sundry.model.Review;

public interface ReviewDao {

    // Create Review
    public void insertReview(Review review);

    public void updateReview(Review review);
    
    // Read Review
    public List<Review> findAll();

    // Read Review
    public List<Review> findAllById(String id);

    // Delete Review
    public void deleteById(String id);
}
