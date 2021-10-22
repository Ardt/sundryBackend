package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.MongoTestDocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Indexed;

@Indexed
public interface MongoCustomizedUserRepository extends MongoRepository<MongoTestDocument, String> {
    public List<MongoTestDocument> findByTitle(String title);
}