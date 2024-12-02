package org.eun.e_blog.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.exception.ErrorCode;

@RequiredArgsConstructor
@Getter
public enum FriendErrorCode implements ErrorCode {
    ASSIGN_NOT_FOUND( 404, "FE001", "해당 신청을 찾을 수 없습니다."),
    ASSIGN_WRONG_RESULT( 405, "FE002", "잘못된 입력 값이 존재합니다." );

    private final int status;
    private final String code;
    private final String message;
}
