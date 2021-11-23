package com.ardt.sundry.dto;

import static org.junit.Assert.assertEquals;

import com.ardt.sundry.model.Location;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class LocationDTOTest {

    @Test
    public void getTest() throws Exception {
        
        final String testId = RandomStringUtils.random(10);
        final Double testLat = RandomUtils.nextDouble();
        final Double testLng = RandomUtils.nextDouble();
        final String testAddrS = RandomStringUtils.random(10);
        final String testAddrT = RandomStringUtils.random(10);
        final String testName = RandomStringUtils.random(10);

        final LocationDTO locationDto = LocationDTO.builder()
            .id(testId)
            .lat(testLat)
            .lng(testLng)
            .addrS(testAddrS)
            .addrT(testAddrT)
            .name(testName)
            .build();

        Location location = locationDto.toLocation();

        assertEquals(testId, location.getId());
        assertEquals(testLat, location.getLat());
        assertEquals(testLng, location.getLng());
        assertEquals(testAddrS, location.getAddrS());
        assertEquals(testAddrT, location.getAddrT());
        assertEquals(testName, location.getName());
    }
}
