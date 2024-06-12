package com.example.uberprojectlocationservice.controllers;

import com.example.uberprojectlocationservice.dto.DriverLocationDto;
import com.example.uberprojectlocationservice.dto.SaveDriverLocationRequestDto;
import com.example.uberprojectlocationservice.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService=locationService;
    }

    @PostMapping("/drivers")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody SaveDriverLocationRequestDto saveDriverLocationRequestDto){
        try{
            System.out.println(saveDriverLocationRequestDto.getDriverId()+saveDriverLocationRequestDto.getLatitude());
            Boolean response= locationService.saveDriverLocation(saveDriverLocationRequestDto.getDriverId(), saveDriverLocationRequestDto.getLatitude(),saveDriverLocationRequestDto.getLongitude());
            System.out.println(response);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(false, HttpStatus.CREATED);
        }
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverLocationDto>> getNearByDrivers(@RequestBody DriverLocationDto driverLocationDto){
        try{
            List<DriverLocationDto> drivers=locationService.getNearByDrivers(driverLocationDto.getLatitude(), driverLocationDto.getLongitude());
            return new ResponseEntity<>(drivers,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
