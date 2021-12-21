package com.cheese.admin.exception;

import com.cheese.admin.error.ErrorCode;

public class CouponNotFoundException extends CustomException{
    private static final long serialVersionUID = -2116671122895194101L;
    public CouponNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.INVALID_TYPE_VALUE);
    }


}
