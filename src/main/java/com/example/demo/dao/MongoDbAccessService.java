package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Customer;
import com.example.demo.model.MongoTestDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Repository("MongoDB")
public class MongoDbAccessService implements MongoDbDao {

    @Autowired
    private MongoCustomizedUserRepository testRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Optional<MongoTestDocument> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<MongoTestDocument> findAllByTitle(String lastName) {
        return testRepository.findAll();

        // return mongoTemplate.findAll(MongoTestDocument.class);
    }

    @Override
    public void insertMongo(String title) {
        // MongoTestDocument mongo = new MongoTestDocument(title);
        // testRepository.insert(Arrays.asList(mongo));
    }
    
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public String getCollection(String collectionName) {
        System.out.println("Test Start");

        Customer c1 = new Customer(UUID.randomUUID().toString());
        System.out.println(c1.toString());
        customerRepository.insert(c1);

        List<Customer> c2 = customerRepository.findAll();
        System.out.println(c2.toString());

        return c2.toString();
    }
}
