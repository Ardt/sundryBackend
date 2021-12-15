package com.ardt.sundry.service;

import static org.mockito.Mockito.verify;

import com.ardt.sundry.dao.LocationDao;
import com.ardt.sundry.model.Location;
import com.ardt.sundry.util.RandomModel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationDao locationDao;

    @InjectMocks
    private LocationService locationService;

    @Test
    void basicTest() throws Exception {
        final Location location = RandomModel.getRandomLocation();

        locationService.insertLocation(location);
        verify(locationDao).insertLocation(location);

        locationService.updateLocation(location);
        verify(locationDao).updateLocation(location);

        locationService.findAll();
        verify(locationDao).findAll();

        locationService.findAllById(location.getId());
        verify(locationDao).findById(location.getId());

        locationService.deleteById(location.getId());
        verify(locationDao).deleteById(location.getId());
    }
}
