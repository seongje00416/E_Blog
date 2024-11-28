package org.eun.e_blog.user.exception;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.exception.ErrorCode;

@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {
    USER_NOT_FOUND( 404, "UE001", "해당 사용자를 찾을 수 없습니다." );

    private final int status;
    private final String code;
    private final String message;

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}
