package com.example.uberprojectlocationservice.services;

import com.example.uberprojectlocationservice.dto.DriverLocationDto;

import java.util.List;

public interface LocationService {

    Boolean saveDriverLocation(String driverId,Double latitude, Double longitude);
    List<DriverLocationDto> getNearByDrivers(Double latitude, Double longitude);

}
