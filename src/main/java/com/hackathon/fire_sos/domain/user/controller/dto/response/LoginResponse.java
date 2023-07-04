package com.hackathon.fire_sos.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private String accessToken;

    private String refreshToken;

}
