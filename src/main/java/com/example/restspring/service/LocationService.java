package com.example.restspring.service;

import com.example.restspring.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();
    String findAddressById(Long id);

}
