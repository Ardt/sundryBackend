package com.ardt.sundry.dao;

import java.util.List;

import com.ardt.sundry.model.BasicLocation;

public interface BasicLocationDao {

    // Create BasicLocation
    public void insertBasicLocation(Double lat, Double lng);

    // Read BasicLocation
    public List<BasicLocation> findAll();

    // Read BasicLocation
    public List<BasicLocation> findAllById(String id);

    // Delete BasicLocation
    public void deleteById(String id);

    // Delete BasicLocation
    public void removeById(String id);
}
