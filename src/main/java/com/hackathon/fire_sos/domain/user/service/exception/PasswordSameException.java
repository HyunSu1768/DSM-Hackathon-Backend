package com.hackathon.fire_sos.domain.user.service.exception;


import com.hackathon.fire_sos.global.error.exception.BusinessException;
import com.hackathon.fire_sos.global.error.exception.ErrorCode;

public class PasswordSameException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordSameException();

    public PasswordSameException() {
        super(ErrorCode.PASSWORD_SAME);
    }
}
