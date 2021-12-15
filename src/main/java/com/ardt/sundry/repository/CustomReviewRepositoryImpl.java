package com.ardt.sundry.repository;

import com.ardt.sundry.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

class CustomReviewRepositoryImpl implements CustomReviewRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateReview(Review review) {
        Update update = new Update();
        update.set("userId", review.getUserId());
        update.set("locationId", review.getLocationId());
        update.set("body", review.getBody());
        mongoTemplate.findAndModify(
            Query.query(Criteria.where("id").is(review.getId())),
            update, Review.class);
    }
}
