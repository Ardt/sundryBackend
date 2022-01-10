package com.ardt.sundry.api;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.ardt.sundry.dto.ReviewDTO;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;
@WebMvcTest(controllers = { ReviewController.class })
class ReviewControllerTest {
    static final private String rootPath = "/api/v1/review/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    private Gson gson = new Gson();
    private ObjectMapper mapper = new ObjectMapper();

    void getMockedReview(List<Review> Reviews) throws Exception {
        mockMvc.perform(get(rootPath)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(Reviews)))
                .andDo(print());
    }

    @DisplayName("Basic CRUD Test")
    @Test
    void basicCRUDTest() throws Exception {
        String reviewId = "TestReviewId";
        String userId = "testUserId";
        String locationId = "testLocationId";
        String body = "TestBody";
        String testBodyNew = "TestBodyNew";
        ReviewDTO ReviewDto = ReviewDTO.builder()
                .id(reviewId)
                .userId(userId)
                .locationId(locationId)
                .body(body)
                .build();
        List<Review> reviews = new ArrayList<Review>();
        given(reviewService.findAll()).willReturn(reviews);
        //given(reviewService.findAllById(reviewId)).willReturn(reviews);
        given(reviewService.findById(reviewId)).willReturn(
            reviews.stream()
                .filter(review -> review.getId() == reviewId)
                .findFirst());

        // Get all object API test
        getMockedReview(reviews);

        mockMvc.perform(put(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(mapper.writeValueAsString(ReviewDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        // Add object
        reviews.add(ReviewDto.toReview());

        getMockedReview(reviews);

        // Modify object API Test
        mockMvc.perform(post(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(mapper.writeValueAsString(ReviewDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        // Modify object
        ReviewDto.setBody(testBodyNew);
        reviews.remove(0);
        reviews.add(ReviewDto.toReview());

        getMockedReview(reviews);

        given(reviewService.findById(reviewId)).willReturn(
            reviews.stream()
                .filter(review -> review.getId() == reviewId)
                .findFirst());
        
        mockMvc.perform(get(rootPath + reviewId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(reviews.get(0))))
                .andDo(print());

                // Delete object API Test
        mockMvc.perform(delete(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(reviewId))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        reviews.remove(0);

        given(reviewService.findById(reviewId)).willReturn(
            reviews.stream()
                .filter(review -> review.getId() == reviewId)
                .findFirst());

        mockMvc.perform(get(rootPath + String.format("/%s", reviewId))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("null"))
                .andDo(print());
    }
}