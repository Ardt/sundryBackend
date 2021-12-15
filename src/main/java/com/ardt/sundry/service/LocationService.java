package com.ardt.sundry.service;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.dao.LocationDao;
import com.ardt.sundry.model.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationDao locationDao;

    @Autowired
    public LocationService(@Qualifier("LocationMongo") LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public void insertLocation(Location location) {
        locationDao.insertLocation(location);
    }

    public void updateLocation(Location location) {
        locationDao.updateLocation(location);
    }

    public List<Location> findAll() {
        return locationDao.findAll();
    }

    public Optional<Location> findAllById(String id) {
        return locationDao.findById(id);
    }

    public void deleteById(String id) {
        locationDao.deleteById(id);
    }
}