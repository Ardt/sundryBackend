package com.ardt.sundry.service;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.dao.ReviewDao;
import com.ardt.sundry.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewDao reviewDao;

    @Autowired
    public ReviewService(@Qualifier("ReviewMongo") ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public void insertReview(Review review) {
        reviewDao.insertReview(review);
    }

    public void updateReview(Review review) {
        reviewDao.updateReview(review);
    }

    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    public Optional<Review> findById(String id) {
        return reviewDao.findById(id);
    }

    public void deleteById(String id) {
        reviewDao.deleteById(id);
    }
}