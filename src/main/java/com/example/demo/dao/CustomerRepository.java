package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    public List<Customer> findCustomerByName(String name);
}
