package com.hackathon.fire_sos.domain.user.service.exception;


import com.hackathon.fire_sos.global.error.exception.BusinessException;
import com.hackathon.fire_sos.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
