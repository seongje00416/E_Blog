package org.eun.e_blog.user.exception;

import org.eun.e_blog.common.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException() {
        super( UserErrorCode.USER_NOT_FOUND );
    }
}
