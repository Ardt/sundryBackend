package com.ardt.sundry.dao.impl;

import java.util.List;
import java.util.UUID;

import com.ardt.sundry.dao.intf.ReviewDao;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository("ReviewMongo")
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public ReviewDaoImpl(ReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Review> findAllById(String title) {
        return reviewRepository.findById(UUID.fromString(title));
    }

    @Override
    public void insertReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
        Update update = new Update();
        update.set("userId", review.getUserId());
        update.set("locationId", review.getLocationId());
        update.set("body", review.getBody());
        mongoTemplate.findAndModify(
            Query.query(Criteria.where("id").is(review.getId())),
            update, Review.class);
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
