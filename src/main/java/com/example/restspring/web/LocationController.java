package com.example.restspring.web;

import com.example.restspring.entity.Location;
import com.example.restspring.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    private LocationService locationService;

    @Autowired
    public void setLocationService(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/Location")
        public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> list = locationService.retrieveLocations();
        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
        String address = locationService.findAddressById(id);
        return new ResponseEntity<String>(address, HttpStatus.OK);
    }
}




