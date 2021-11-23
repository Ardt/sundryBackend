package com.ardt.sundry.api;

import com.ardt.sundry.service.LocationService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {LocationController.class})
public class LocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @DisplayName("given object to save when save object using MongoDB template then object is saved")
    @Test
    public void makeNewLocation() throws Exception {
    }
}
