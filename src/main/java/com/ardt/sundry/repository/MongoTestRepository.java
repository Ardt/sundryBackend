package com.ardt.sundry.repository;

import java.util.List;

import com.ardt.sundry.model.MongoTest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoTestRepository extends MongoRepository<MongoTest, String> {
    public List<MongoTest> findByTitle(String title);
    public void deleteByTitle(String title);
    public void removeByTitle(String title);
}