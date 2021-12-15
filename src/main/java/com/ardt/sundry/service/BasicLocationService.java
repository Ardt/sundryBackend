package com.ardt.sundry.service;

import java.util.List;

import com.ardt.sundry.dao.BasicLocationDao;
import com.ardt.sundry.model.BasicLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BasicLocationService {

    private final BasicLocationDao basicLocationDao;

    @Autowired
    public BasicLocationService(@Qualifier("BasicLocation") BasicLocationDao basicLocationDao) {
        this.basicLocationDao = basicLocationDao;
    }

    public void insertBasicLocation(Double lat, Double lng) {
        basicLocationDao.insertBasicLocation(lat, lng);
    }

    public List<BasicLocation> findAll() {
        return basicLocationDao.findAll();
    }

    public List<BasicLocation> findAllById(String id) {
        return basicLocationDao.findAllById(id);
    }

    public void deleteById(String id) {
        basicLocationDao.deleteById(id);
    }

    public void removeById(String id) {
        basicLocationDao.removeById(id);
    }
}