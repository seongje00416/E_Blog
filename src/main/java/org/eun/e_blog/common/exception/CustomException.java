package org.eun.e_blog.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 6948002959123829946L;
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode.getMessage(), throwable);
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}