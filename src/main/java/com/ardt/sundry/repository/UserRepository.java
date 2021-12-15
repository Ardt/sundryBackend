package com.ardt.sundry.repository;

import java.util.Optional;

import com.ardt.sundry.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
