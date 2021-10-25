package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.MongoTestDocument;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoTestDocumentRepository extends MongoRepository<MongoTestDocument, String> {
    public List<MongoTestDocument> findByTitle(String title);
}