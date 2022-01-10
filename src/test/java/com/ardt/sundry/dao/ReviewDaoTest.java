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

import com.ardt.sundry.model.Review;
import com.ardt.sundry.util.RandomModel;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@EnableMongoRepositories("com.ardt.sundry.dao")
@ComponentScan("com.ardt.sundry.dao")
class ReviewDaoTest {

    @Autowired(required=true)
    private ReviewDao reviewDao;

    private Review initData;

    @BeforeEach
    public void setup() {
        String userId = "testUserId";
        String locationId = "testLocationId";
        initData = RandomModel.getRandomReview(userId, locationId);
    }

    @DisplayName("basic CRUD test")
    @Test
    void basicCRUDTest() throws Exception {
        assertEquals(Optional.empty(), reviewDao.findById(initData.getId()));

        reviewDao.insertReview(initData);

        assertNotNull(reviewDao.findById(initData.getId()));
        assertEquals(1, reviewDao.findAll().size());
        String changed = RandomStringUtils.random(10);
        initData.setBody(changed);

        reviewDao.updateReview(initData);
        assertEquals(changed, reviewDao.findById(initData.getId()).get().getBody());
        reviewDao.deleteById(initData.getId());
        assertEquals(Optional.empty(), reviewDao.findById(initData.getId()));
        assertEquals(0, reviewDao.findAll().size());
    }
}