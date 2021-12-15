package com.ardt.sundry.service;

import static org.mockito.Mockito.verify;

import com.ardt.sundry.dao.ReviewDao;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.util.RandomModel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    private ReviewDao reviewDao;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void makeNewReview() throws Exception {
        final Review review = RandomModel.getRandomReview("testUserId", "testLocationId");

        reviewService.insertReview(review);
        verify(reviewDao).insertReview(review);

        reviewService.updateReview(review);
        verify(reviewDao).updateReview(review);

        reviewService.findAll();
        verify(reviewDao).findAll();

        reviewService.findById(review.getId());
        verify(reviewDao).findById(review.getId());

        reviewService.deleteById(review.getId());
        verify(reviewDao).deleteById(review.getId());
    }
}