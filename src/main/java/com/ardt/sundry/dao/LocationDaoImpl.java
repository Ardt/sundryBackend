package com.ardt.sundry.dao;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.model.Location;
import com.ardt.sundry.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("LocationMongo")
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    
    @Override
    public Optional<Location> findById(String id) {
        return locationRepository.findById(id);
    }

    @Override
    public String insertLocation(Location location) {
        return locationRepository.insert(location).toString();
    }
    
    @Override
    public String updateLocation(Location location) {
        locationRepository.updateLocation(location);
        return location.toString();
    }

    @Override
    public void deleteById(String id) {
        locationRepository.deleteById(id);
    }
}
