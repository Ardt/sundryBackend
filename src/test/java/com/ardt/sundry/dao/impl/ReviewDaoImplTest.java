package com.ardt.sundry.dao.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import com.ardt.sundry.model.Review;
import com.ardt.sundry.repository.ReviewRepository;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ReviewDaoImplTest {
    /*
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findAllTest() {
        List<Review> actual = reviewRepository.findAll();
        assertNotEquals(0, actual.size());
    }
    */
}