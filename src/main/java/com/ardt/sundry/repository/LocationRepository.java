package com.ardt.sundry.repository;

import com.ardt.sundry.model.Location;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}