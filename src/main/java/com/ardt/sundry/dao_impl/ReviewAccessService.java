package com.ardt.sundry.dao_impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.ardt.sundry.dao.ReviewDao;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("Review")
public class ReviewAccessService implements ReviewDao {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAllById(String title) {
        return reviewRepository.findById(UUID.fromString(title));
    }

    @Override
    public void insertReview(String location, String body) {
        Review mongo = new Review(location, body);
        reviewRepository.insert(Arrays.asList(mongo));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void removeById(String id) {
        // TODO Auto-generated method stub
    }
}
