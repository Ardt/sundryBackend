package com.ardt.sundry.api;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.ardt.sundry.dto.LocationDTO;
import com.ardt.sundry.model.Location;
import com.ardt.sundry.service.LocationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = { LocationController.class })
class LocationControllerTest {
    static final private String rootPath = "/api/v1/location/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    private Gson gson = new Gson();
    private ObjectMapper mapper = new ObjectMapper();

    void getMockedLocation(List<Location> locations) throws Exception {
        mockMvc.perform(get(rootPath)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(locations)))
                .andDo(print());
    }

    @DisplayName("Basic CRUD Test")
    @Test
    void basicCRUDTest() throws Exception {
        String locationId = "TestLocationId";
        String testAddrT = "testAddrT";
        String testAddrS = "testAddrS";
        String testName = "TestName";
        String testAddrSNew = "testAddrSNew";
        LocationDTO locationDto = LocationDTO.builder()
                .id(locationId)
                .lat(RandomUtils.nextDouble())
                .lng(RandomUtils.nextDouble())
                .addrT(testAddrT)
                .addrS(testAddrS)
                .name(testName)
                .build();
        List<Location> locations = new ArrayList<Location>();
        given(locationService.findAll()).willReturn(locations);

        // Get all object API test
        getMockedLocation(locations);

        mockMvc.perform(put(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(mapper.writeValueAsString(locationDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        // Add object
        locations.add(locationDto.toLocation());

        getMockedLocation(locations);

        // Modify object API Test
        mockMvc.perform(post(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(mapper.writeValueAsString(locationDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        // Modify object
        locationDto.setAddrS(testAddrSNew);
        locations.remove(0);
        locations.add(locationDto.toLocation());

        getMockedLocation(locations);

        // Delete object API Test
        mockMvc.perform(delete(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(locationId))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        locations.remove(0);
        getMockedLocation(locations);
    }
}
