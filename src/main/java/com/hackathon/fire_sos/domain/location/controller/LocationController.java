package com.hackathon.fire_sos.domain.location.controller;

import com.hackathon.fire_sos.domain.location.controller.dto.request.LocationRequest;
import com.hackathon.fire_sos.domain.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/location")
@RequiredArgsConstructor
@RestController
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public void addLocation(@RequestBody LocationRequest request){
        locationService.createLocation(request);
    }

    @PutMapping
    public void editLocation(@RequestBody LocationRequest request){
        locationService.updateLocation(request);
    }
}
