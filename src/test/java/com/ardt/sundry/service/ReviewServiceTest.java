package com.ardt.sundry.service;

import static org.mockito.Mockito.verify;

import com.ardt.sundry.dao.intf.ReviewDao;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.util.RandomModel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    private ReviewDao locationDao;

    @InjectMocks
    private ReviewService locationService;

    @DisplayName("given object to save when save object using MongoDB template then object is saved")
    @Test
    public void makeNewReview() throws Exception {
        final Review location = RandomModel.getRandomReview("testUserId", "testLocationId");

        locationService.insertReview(location);

        verify(locationDao).insertReview(location);

        // assertEquals(location.getId(), locationDao.findAll().get(0).getId());
    }
}
