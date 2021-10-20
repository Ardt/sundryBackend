package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Mongo;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

@Repository("MongoDB")
public class MongoDbAccessService implements MongoDbDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<Mongo> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<Mongo> findAllByTitle(String lastName) {
        return null;
    }
    
	@Override
	public void insertMongo(UUID id, String title) {
        mongoTemplate.insert(id, title);
	}
}
