package com.hnsdksx.app_counterpartapi.constant;


/**
 * 自定义断言接口
 *
 * @author kuangbaoting
 */
public interface Assert {


    default void newException() {
        throw new AssertException(getMessage(),getCode());
    }

    String getMessage();
    Integer getCode();

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
