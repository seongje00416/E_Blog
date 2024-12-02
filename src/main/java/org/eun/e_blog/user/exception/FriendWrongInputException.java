package org.eun.e_blog.user.exception;

import org.eun.e_blog.common.exception.CustomException;

public class FriendWrongInputException extends CustomException {
    public FriendWrongInputException() { super( FriendErrorCode.ASSIGN_WRONG_RESULT); }
}
