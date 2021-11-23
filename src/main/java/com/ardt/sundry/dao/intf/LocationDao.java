package com.ardt.sundry.dao.intf;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.model.Location;

public interface LocationDao {

    // Create BasicLocation
    public String insertLocation(Location location);

    public String updateLocation(Location location);

    // Read BasicLocation
    public List<Location> findAll();

    // Read BasicLocation
    public Optional<Location> findById(String id);

    // Delete BasicLocation
    public void deleteById(String id);
}
