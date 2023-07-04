package com.hackathon.fire_sos.global.exception;


import com.hackathon.fire_sos.global.error.exception.BusinessException;
import com.hackathon.fire_sos.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
