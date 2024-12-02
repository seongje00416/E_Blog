package org.eun.e_blog.user.exception;

import org.eun.e_blog.common.exception.CustomException;

public class FriendNotFoundException extends CustomException {
    public FriendNotFoundException() { super( FriendErrorCode.ASSIGN_NOT_FOUND ); }
}
