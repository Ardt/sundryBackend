package com.ardt.sundry.repository;

import java.util.List;
import java.util.UUID;

import com.ardt.sundry.model.BasicLocation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasicLocationRepository extends MongoRepository<BasicLocation, String> {
    public List<BasicLocation> findById(UUID id);
    public void deleteById(UUID id);
    public void removeById(UUID id);
}