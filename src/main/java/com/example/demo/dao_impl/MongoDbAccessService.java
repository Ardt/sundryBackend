package com.example.demo.dao_impl;

import java.util.Arrays;
import java.util.List;

import com.example.demo.dao.MongoDbDao;
import com.example.demo.model.MongoTestDocument;
import com.example.demo.repository.MongoTestDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("MongoDB")
public class MongoDbAccessService implements MongoDbDao {

    @Autowired
    private MongoTestDocumentRepository mongoTestDocumentRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<MongoTestDocument> findAllByTitle(String title) {
        return mongoTestDocumentRepository.findByTitle(title);
    }

    @Override
    public void insertMongo(String title) {
        MongoTestDocument mongo = new MongoTestDocument(title);
        mongoTestDocumentRepository.insert(Arrays.asList(mongo));
    }

    @Override
    public List<MongoTestDocument> findAll() {
        return mongoTestDocumentRepository.findAll();
    }

    @Override
    public void removeByTitle(String title) {
        // TODO Auto-generated method stub
    }

    @Override
    public void removeAllByTitle(String title) {
        // TODO Auto-generated method stub
    }
}
