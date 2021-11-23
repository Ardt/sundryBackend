package com.ardt.sundry.service;

import com.ardt.sundry.dao.intf.LocationDao;
import com.ardt.sundry.model.Location;
import com.ardt.sundry.util.RandomModel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class LocationServiceTest {

    @Mock
    private LocationDao locationDao;

    @InjectMocks
    private LocationService locationService;

    @DisplayName("given object to save when save object using MongoDB template then object is saved")
    @Test
    public void makeNewLocation() throws Exception {
        final Location location = RandomModel.getLocation();

        locationService.insertLocation(location);

        // verify(locationDao).insertLocation(location);

        // assertEquals(location.getId(), locationDao.findAll().get(0).getId());
    }
}
