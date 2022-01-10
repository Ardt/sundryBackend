package com.ardt.sundry.util;

import com.ardt.sundry.model.Location;
import com.ardt.sundry.model.Review;
import com.ardt.sundry.model.User;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomModel {

    public static Location getRandomLocation() {
        return Location.builder()
            .id(RandomStringUtils.random(10))
            .lat(RandomUtils.nextDouble())
            .lng(RandomUtils.nextDouble())
            .addrS(RandomStringUtils.random(10))
            .addrT(RandomStringUtils.random(10))
            .name(RandomStringUtils.random(10))
            .build();
    }

    public static User getRandomUser() {
        return User.builder()
            .id(RandomStringUtils.random(10))
            .name(RandomStringUtils.random(10))
            .email(String.format("%s@gmail.com", RandomStringUtils.random(10)))
            .build();
    }

    public static Review getRandomReview(String userId, String locationId) {
        return Review.builder()
            .id(RandomStringUtils.random(10))
            .userId(userId)
            .locationId(locationId)
            .body(RandomStringUtils.random(10))
            .build();
    }
}
