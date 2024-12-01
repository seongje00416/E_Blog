package org.eun.e_blog.post.exception;

import org.eun.e_blog.common.exception.CustomException;

public class PostNotFoundException extends CustomException {
    public PostNotFoundException() { super( PostErrorCode.POST_NOT_FOUND ); }
}
