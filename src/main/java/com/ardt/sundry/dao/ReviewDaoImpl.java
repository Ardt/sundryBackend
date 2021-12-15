package com.ardt.sundry.dao;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.model.Review;
import com.ardt.sundry.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository("ReviewMongo")
@RequiredArgsConstructor
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findById(String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void insertReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.updateReview(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        reviewRepository.deleteById(id);
    }
}
