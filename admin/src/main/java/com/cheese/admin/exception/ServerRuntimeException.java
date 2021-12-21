package com.cheese.admin.exception;

import com.cheese.admin.error.InternalErrorCode;
import lombok.Getter;

@Getter
public class ServerRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -2575717184560818381L;
    private final InternalErrorCode errorCode;

    public ServerRuntimeException(InternalErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServerRuntimeException(InternalErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServerRuntimeException(InternalErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServerRuntimeException(InternalErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public static ServerRuntimeException makeInternalServerError(Throwable cause) {
        return new ServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, cause);
    }


    public static ServerRuntimeException makeCredNotFoundUser(String rpId, String userId) {
        throw new ServerRuntimeException(InternalErrorCode.CREDENTIAL_NOT_FOUND,
                "RpId: " + rpId + "; UserId: " + userId);
    }

}
