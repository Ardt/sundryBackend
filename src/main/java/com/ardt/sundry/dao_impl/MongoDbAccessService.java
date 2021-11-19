package com.ardt.sundry.dao_impl;

import java.util.Arrays;
import java.util.List;

import com.ardt.sundry.dao.MongoTestDao;
import com.ardt.sundry.model.MongoTest;
import com.ardt.sundry.repository.MongoTestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("MongoDB")
public class MongoDbAccessService implements MongoTestDao {

    @Autowired
    private MongoTestRepository mongoTestDocumentRepository;

    // @Autowired
    // private MongoOperations mongoOperations;

    @Override
    public List<MongoTest> findAllByTitle(String title) {
        return mongoTestDocumentRepository.findByTitle(title);
    }

    @Override
    public void insertMongo(String title) {
        MongoTest mongo = new MongoTest(title);
        mongoTestDocumentRepository.insert(Arrays.asList(mongo));
    }

    @Override
    public List<MongoTest> findAll() {
        return mongoTestDocumentRepository.findAll();
    }

    @Override
    public void deleteByTitle(String title) {
        mongoTestDocumentRepository.deleteByTitle(title);
    }

    @Override
    public void removeByTitle(String title) {
        mongoTestDocumentRepository.removeByTitle(title);
    }
}
