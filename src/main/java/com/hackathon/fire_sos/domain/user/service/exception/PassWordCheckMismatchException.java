package com.hackathon.fire_sos.domain.user.service.exception;


import com.hackathon.fire_sos.global.error.exception.BusinessException;
import com.hackathon.fire_sos.global.error.exception.ErrorCode;

public class PassWordCheckMismatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PassWordCheckMismatchException();

    public PassWordCheckMismatchException() {
        super(ErrorCode.PASSWORD_CHECK_MISMATCH);
    }
}
