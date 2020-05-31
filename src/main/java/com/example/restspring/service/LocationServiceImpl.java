package com.example.restspring.service;

import com.example.restspring.entity.Location;
import com.example.restspring.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;


    @Override
    public List<Location> retrieveLocations() {
        return (List<Location>)locationRepository.findAll();
    }

    @Override
    public String findAddressById(Long id) {

        Optional<String> optionalAddress=Optional.ofNullable(locationRepository.findAddressById(id));
        //TODO: error message not working needs to fix
        String address = optionalAddress.orElseThrow(LocationNotFoundException::new);

        return address;
    }
}


