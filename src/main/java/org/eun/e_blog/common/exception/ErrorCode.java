package org.eun.e_blog.common.exception;

import java.io.Serializable;

public interface ErrorCode  extends Serializable {
    int getStatus();

    String getCode();

    String getMessage();
}