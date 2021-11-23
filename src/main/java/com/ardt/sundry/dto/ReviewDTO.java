package com.ardt.sundry.dto;

import com.ardt.sundry.model.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Setter
public class ReviewDTO {
    @NonNull public String id;
    private String userId;
    private String locationId;
    private String body;

    public Review toReview() {
        return Review.builder()
            .id(id)
            .userId(userId)
            .locationId(locationId)
            .body(body)
            .build();
    }
}