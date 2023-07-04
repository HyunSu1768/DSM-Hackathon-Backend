package com.hackathon.fire_sos.domain.location.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LocationRequest {

    private Double latitude;

    private Double longitude;

}
