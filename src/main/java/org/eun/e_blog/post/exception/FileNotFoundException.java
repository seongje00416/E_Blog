package org.eun.e_blog.post.exception;

import org.eun.e_blog.common.exception.CustomException;

public class FileNotFoundException extends CustomException {
    public FileNotFoundException() { super( FileErrorCode.FILE_NOT_FOUND ); }
}
