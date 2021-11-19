package com.ardt.sundry.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.ardt.sundry.model.BasicLocation;
import com.ardt.sundry.service.BasicLocationService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/location")
public class BasicLocationController {

    private final BasicLocationService basicLocationService;

    @Autowired
    public BasicLocationController(BasicLocationService basicLocationService) {
        this.basicLocationService = basicLocationService;
    }

    @GetMapping(path = "/")
    public List<BasicLocation> findAll() {
        List<BasicLocation> returnValue = basicLocationService.findAll();
        return returnValue.isEmpty() ? Collections.emptyList() : returnValue;
    }
}