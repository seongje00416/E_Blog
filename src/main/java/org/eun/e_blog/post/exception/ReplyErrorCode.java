package org.eun.e_blog.post.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.exception.ErrorCode;

@RequiredArgsConstructor
@Getter
public enum ReplyErrorCode implements ErrorCode {
    REPLY_NOT_FOUND( 404, "RE001", "해당 댓글을 찾을 수 없습니다." );

    private final int status;
    private final String code;
    private final String message;
}
