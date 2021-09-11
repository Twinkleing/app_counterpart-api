package com.hnsdksx.app_counterpartapi.response;


import com.hnsdksx.app_counterpartapi.constant.Assert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应请求常量
 *
 * @author kuangbaoting
 */
@Getter
@AllArgsConstructor
public enum GlobalConstant implements Assert {

    SUCCESS(200, "成功"),
    ERROR(400, "服务器内部错误"),
    PERMISSION_ERROR(1001, "权限错误"),
    NECESSARY_PARAMS_IS_EMPTY(1002, "缺少必要参数"),
    FILE_IS_EMPTY(1003, "文件为空"),
    DATA_FORMAT_ERROR(1004,"数据格式错误")
    ;

    private Integer code;
    private String message;

}
