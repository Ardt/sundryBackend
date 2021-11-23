package com.ardt.sundry.dao.impl;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.dao.intf.LocationDao;
import com.ardt.sundry.model.Location;
import com.ardt.sundry.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository("LocationMongo")
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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
        Update update = new Update();
        update.set("lat", location.getLat());
        update.set("lng", location.getLng());
        update.set("addrs", location.getAddrS());
        update.set("addrT", location.getAddrT());
        update.set("name", location.getName());
        mongoTemplate.findAndModify(
            Query.query(Criteria.where("id").is(location.getId())),
            update, Location.class);

        return location.toString();
    }

    @Override
    public void deleteById(String id) {
        locationRepository.deleteById(id);
    }
}
