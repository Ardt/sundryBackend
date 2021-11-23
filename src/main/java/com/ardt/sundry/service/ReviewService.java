package com.ardt.sundry.service;

import java.util.List;

import com.ardt.sundry.dao.intf.ReviewDao;
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

    public void insertReview(String locatoin, String body) {
        reviewDao.insertReview(locatoin, body);
    }

    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    public List<Review> findAllById(String id) {
        return reviewDao.findAllById(id);
    }

    public void deleteById(String id) {
        reviewDao.deleteById(id);
    }

    public void removeById(String id) {
        reviewDao.removeById(id);
    }
}