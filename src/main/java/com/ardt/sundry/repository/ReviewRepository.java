package com.ardt.sundry.repository;

import com.ardt.sundry.model.Review;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String>, CustomReviewRepository {
}