package org.eun.e_blog.user.exception;

import org.eun.e_blog.common.exception.CustomException;

public class AccountNotFoundException extends CustomException {
    public AccountNotFoundException() { super( AccountErrorCode.ACCOUNT_NOT_FOUND ); }
}
