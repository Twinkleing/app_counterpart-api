package com.hnsdksx.app_counterpartapi.result;

import com.hnsdksx.app_counterpartapi.exception.ApiException;

/**
 * 封装API的错误码
 * Created by macro on 2019/4/19.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();

    default void newException() {
        throw new ApiException(this);
    }

    default void isFalse(boolean b) {
        if (!b) {
            newException();
        }
    }

    default void isTrue(boolean b) {
        if (b) {
            newException();
        }
    }

    default void isNull(Object object) {
        if (object == null) {
            newException();
        }
    }

    default void noNull(Object object) {
        if (object != null) {
            newException();
        }
    }
}
