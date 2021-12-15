package com.ardt.sundry.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import com.ardt.sundry.model.Location;
import com.ardt.sundry.util.RandomModel;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@EnableMongoRepositories("com.ardt.sundry.dao")
@ComponentScan("com.ardt.sundry.dao")
class LocationDaoTest {

    @Autowired(required=true)
    private LocationDao locationDao;

    private Location initData;

    @BeforeEach
    public void setup() {
        initData = RandomModel.getRandomLocation();
    }

    @DisplayName("basic CRUD test")
    @Test
    void basicCRUDTest() throws Exception {
        assertEquals(Optional.empty(), locationDao.findById(initData.getId()));

        locationDao.insertLocation(initData);
        assertNotNull(locationDao.findById(initData.getId()));
        assertEquals(1, locationDao.findAll().size());

        String changed = RandomStringUtils.random(10);
        initData.setName(changed);
        locationDao.updateLocation(initData);
        assertEquals(changed, locationDao.findById(initData.getId()).get().getName());

        locationDao.deleteById(initData.getId());
        assertEquals(Optional.empty(), locationDao.findById(initData.getId()));
        assertEquals(0, locationDao.findAll().size());
    }
}