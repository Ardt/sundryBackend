package com.ardt.sundry.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class LocationTest {

    @Test
    public void getTest() throws Exception {

        final String testId = RandomStringUtils.random(10);
        final Double testLat = RandomUtils.nextDouble();
        final Double testLng = RandomUtils.nextDouble();
        final String testAddrS = RandomStringUtils.random(10);
        final String testAddrT = RandomStringUtils.random(10);
        final String testName = RandomStringUtils.random(10);

        final Location location = Location.builder()
            .id(testId)
            .lat(testLat)
            .lng(testLng)
            .addrS(testAddrS)
            .addrT(testAddrT)
            .name(testName)
            .build();

        assertEquals(testId, location.getId());
        assertEquals(testLat, location.getLat());
        assertEquals(testLng, location.getLng());
        assertEquals(testAddrS, location.getAddrS());
        assertEquals(testAddrT, location.getAddrT());
        assertEquals(testName, location.getName());
    }
}
