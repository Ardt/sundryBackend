package com.ardt.sundry.api;

import java.util.Collections;
import java.util.List;

import com.ardt.sundry.model.Location;
import com.ardt.sundry.dto.LocationDTO;
import com.ardt.sundry.service.LocationService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/v1/location")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocationController {

    @Autowired
    private final LocationService locationService;
    
    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(path = "/")
    public List<Location> findAll() {
        List<Location> returnValue = locationService.findAll();
        return returnValue.isEmpty() ? Collections.emptyList() : returnValue;
    }

    @PutMapping(path = "/")
    public void addLocation(@Validated @NonNull @RequestBody LocationDTO locationDTO) {
        locationService.insertLocation(locationDTO.toLocation());
    }

    @PostMapping(path = "/")
    public void modifyLocation(@Validated @NonNull @RequestBody LocationDTO locationDTO) {
        locationService.updateLocation(locationDTO.toLocation());
    }

    @DeleteMapping(path = "/")
    public void deleteLocation(@Validated @NonNull @RequestBody String id) {
        locationService.deleteById(id);
    }
}
