package com.ardt.sundry.repository;

import java.util.List;
import java.util.UUID;

import com.ardt.sundry.model.Review;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
    public List<Review> findById(UUID id);
    public void deleteById(UUID id);
    public void removeById(UUID id);
}