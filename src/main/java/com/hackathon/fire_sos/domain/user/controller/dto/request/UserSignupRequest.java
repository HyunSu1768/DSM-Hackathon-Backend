package com.hackathon.fire_sos.domain.user.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignupRequest {

    private String accountId;

    private String password;

    private String passwordCheck;

    private Point location;
}

