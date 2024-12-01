package org.eun.e_blog.post.exception;

import org.eun.e_blog.common.exception.CustomException;

public class ReplyNotFoundException extends CustomException {
    public ReplyNotFoundException() { super( ReplyErrorCode.REPLY_NOT_FOUND ); }
}
