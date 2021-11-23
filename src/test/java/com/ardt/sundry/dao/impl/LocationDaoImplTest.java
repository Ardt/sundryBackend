package com.ardt.sundry.dao.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import com.ardt.sundry.model.Location;
import com.ardt.sundry.repository.LocationRepository;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
/*
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class LocationDaoImplTest {

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private LocationDaoImpl LocationDaoImpl;

    @Test
    public void findAllTest() {
        List<Location> actual = LocationDaoImpl.findAll();
        assertNotEquals(0, actual.size());
    }
}
*/