package com.ardt.sundry.repository;

import com.ardt.sundry.model.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

class CustomLocationRepositoryImpl implements CustomLocationRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateLocation(Location location) {
        Update update = new Update();
        update.set("lat", location.getLat());
        update.set("lng", location.getLng());
        update.set("addrS", location.getAddrS());
        update.set("addrT", location.getAddrT());
        update.set("name", location.getName());
        mongoTemplate.findAndModify(
            Query.query(Criteria.where("id").is(location.getId())),
            update, Location.class);
    }
}
