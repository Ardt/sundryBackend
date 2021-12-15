package com.ardt.sundry.dao;

import java.util.List;

import com.ardt.sundry.model.Review;

public interface ReviewDao {

    // Create Review
    public void insertReview(String location, String body);

    // Read Review
    public List<Review> findAll();

    // Read Review
    public List<Review> findAllById(String id);

    // Delete Review
    public void deleteById(String id);

    // Delete Review
    public void removeById(String id);
}
