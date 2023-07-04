package com.hackathon.fire_sos.global.error.exception;

public class ExpiredTokenException extends BusinessException{

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
