package com.example.uberprojectlocationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NearbyDriversRequestDto {
    Double latitude;
    Double longitude;

}
