package com.hackathon.fire_sos.domain.user.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignupRequest {

    private String accountId;

    private String password;

    private String passwordCheck;

}

