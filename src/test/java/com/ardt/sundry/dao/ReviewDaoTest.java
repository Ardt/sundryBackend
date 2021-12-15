package com.ardt.sundry.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ReviewDaoTest {

    @Autowired
    private ReviewDao reviewDao;

    @Test
    public void testReviewDao() throws Exception {
        // assertNotNull(reviewDao);
    }
}
