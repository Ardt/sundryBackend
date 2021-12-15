package com.ardt.sundry.api;

import java.util.ArrayList;
import java.util.List;

import com.ardt.sundry.model.Location;
import com.ardt.sundry.service.LocationService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {LocationController.class})
class LocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @DisplayName("given object to save when save object using MongoDB template then object is saved")
    @Test
    void makeNewLocation() throws Exception {
        List<Location> locations = new ArrayList<Location>();
        given(locationService.findAll()).willReturn(locations);
        
        mockMvc.perform(get("/api/v1/location/").contentType(MediaType.APPLICATION_JSON)
            .content(locations.toString()))
            .andExpect(status().isOk())
            .andExpect(content().string("[]"))
            .andDo(print());
    }
}
