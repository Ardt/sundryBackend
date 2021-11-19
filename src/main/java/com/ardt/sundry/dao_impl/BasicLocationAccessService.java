package com.ardt.sundry.dao_impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.ardt.sundry.dao.BasicLocationDao;
import com.ardt.sundry.model.BasicLocation;
import com.ardt.sundry.repository.BasicLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("BasicLocation")
public class BasicLocationAccessService implements BasicLocationDao {

    @Autowired
    private BasicLocationRepository basicLocationRepository;

    @Override
    public List<BasicLocation> findAllById(String title) {
        return basicLocationRepository.findById(UUID.fromString(title));
    }

    @Override
    public void insertBasicLocation(Double lat, Double lng) {
        BasicLocation mongo = new BasicLocation(lat, lng);
        basicLocationRepository.insert(Arrays.asList(mongo));
    }

    @Override
    public List<BasicLocation> findAll() {
        return basicLocationRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void removeById(String id) {
        // TODO Auto-generated method stub
    }
}
