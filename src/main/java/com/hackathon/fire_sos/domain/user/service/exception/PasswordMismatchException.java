package com.hackathon.fire_sos.domain.user.service.exception;


import com.hackathon.fire_sos.global.error.exception.BusinessException;
import com.hackathon.fire_sos.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }


}
