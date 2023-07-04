package com.hackathon.fire_sos.domain.location.service;

import com.hackathon.fire_sos.domain.location.controller.dto.request.LocationRequest;
import com.hackathon.fire_sos.domain.location.entity.Location;
import com.hackathon.fire_sos.domain.location.repository.LocationRepository;
import com.hackathon.fire_sos.domain.user.entity.User;
import com.hackathon.fire_sos.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    private final UserFacade userFacade;

    public void createLocation(LocationRequest request){

        User user = userFacade.currentUser();

        Location location = Location.builder()
                .user(user)
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();

        user.setLocation(location);

        locationRepository.save(location);

    }

    public void updateLocation(LocationRequest request){
        User user = userFacade.currentUser();
        Location location = user.getLocation();
        location.changeLocation(request.getLatitude(), request.getLongitude());
    }

}
