package com.hnsdksx.app_counterpartapi.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *自定义响应返回结果
 *
 * @param <T>
 * @author kuangbaoting
 */
@Getter
@ToString
@NoArgsConstructor
public class Response<T> {
    private Integer code=200;
    private String message="操作成功";
    private T data;

    private Response(T data) {
        this.data = data;
    }

    public static <T> Response<T> success(T data) {

        return new Response<>(data);
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> error(Integer code, String message) {
        Response<T> response = new Response<>();
        response.code = code;
        response.message = message;
        return response;
    }

    public static <T> Response<T> error() {
        return error(400,"操作失败");
    }
}
