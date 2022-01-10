package com.ardt.sundry.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.ardt.sundry.dto.ReviewDTO;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.service.ReviewService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/v1/review")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(path = "/")
    public List<Review> findAll() {
        List<Review> returnValue = reviewService.findAll();
        return returnValue.isEmpty() ? Collections.emptyList() : returnValue;
    }

    @GetMapping(path = "/{id}")
    public Optional<Review> findById(@Validated @NotNull @PathVariable("id") String id) {
        return reviewService.findById(id);
    }

    @PostMapping(path = "/")
    public void modifyReview(@Validated @NonNull @RequestBody ReviewDTO reviewDTO) {
        reviewService.updateReview(reviewDTO.toReview());
    }

    @PutMapping(path = "/")
    public void addReview(@Validated @NonNull @RequestBody ReviewDTO reviewDTO) {
        reviewService.insertReview(reviewDTO.toReview());
    }

    @DeleteMapping(path = "/")
    public void deleteReview(@Validated @NonNull @RequestBody String id) {
        reviewService.deleteById(id);
    }
}