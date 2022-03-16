package com.hlfv.democommon.vo;

import lombok.Data;


public class CommonResult<T> {

    private Boolean success;

    private Integer code;

    private String msg;

    private T data;

    public CommonResult() {
    }

    private CommonResult(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    private CommonResult(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(true, 10000, "请求成功", data);
    }

    public static <T> CommonResult<T> fail(Integer code, String msg) {
        return new CommonResult<>(false, code, msg);
    }

    public static <T> CommonResult<T> common(Boolean success, Integer code, String msg, T data) {
        return new CommonResult<>(success, code, msg, data);
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
