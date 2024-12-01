package org.eun.e_blog.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.exception.ErrorCode;

@RequiredArgsConstructor
@Getter
public enum AccountErrorCode implements ErrorCode {
    ACCOUNT_NOT_FOUND( 404, "AE001", "해당 계정을 찾을 수 없습니다." );

    private final int status;
    private final String code;
    private final String message;
}
