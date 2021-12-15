package com.ardt.sundry.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class LocationDaoImplTest {
/*
    // @Mock
    // private LocationRepository locationRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private LocationDaoImpl LocationDaoImpl;

    @Test
    public void findAllTest() {
        List<Location> actual = LocationDaoImpl.findAll();
        assertNotEquals(0, actual.size());
    }
    */
}