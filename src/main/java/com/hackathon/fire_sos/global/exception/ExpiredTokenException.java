package com.hackathon.fire_sos.global.exception;


import com.hackathon.fire_sos.global.error.exception.BusinessException;
import com.hackathon.fire_sos.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
