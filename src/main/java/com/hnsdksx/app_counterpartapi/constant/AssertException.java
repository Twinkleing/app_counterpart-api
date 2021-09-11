package com.hnsdksx.app_counterpartapi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 断言异常接口，继承运行时异常{@link RuntimeException}
 *
 * @author kuangbaoting
 */
@AllArgsConstructor
@Getter
public class AssertException extends RuntimeException{
    private final String message;
    private final Integer code;
}
