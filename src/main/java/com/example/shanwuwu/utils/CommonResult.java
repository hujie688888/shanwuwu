package com.example.shanwuwu.utils;

import lombok.Getter;

/**
 * @projectName: shanwuwu
 * @package: com.example.shanwuwu.utils
 * @className: CommonResult
 * @author: hujie
 * @description: TODO
 * @date: 2023/2/27 17:22
 * @version: 1.0
 */
@Getter
public class CommonResult<T> {

    private long code;
    private String message;
    private T data;

    public CommonResult(long code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 封装好的信息
     * @param t
     * @param <T>
     * @return
     */
    public static <T> CommonResult success(T t){
        return new CommonResult<>(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage(), t);
    }

    /**
     * 重载自定义message
     * @param t
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult success(T t, String message){
        return new CommonResult<>(CommonCode.SUCCESS.getCode(), message, t);
    }

    /**
     * 重载自定义code message
     * @param t
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult success(T t, long code, String message){
        return new CommonResult<>(code, message, t);
    }

    public static <T> CommonResult failed(String message){
        return new CommonResult<>(CommonCode.FAILURE.getCode(), message, null);
    }

    public static<T> CommonResult failed(IErrorCode resultCode){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(),null);
    }

    public static<T> CommonResult failed(IErrorCode resultCode, T data){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(),data);
    }

    public static<T> CommonResult failed(){
        return failed(CommonCode.FAILURE);
    }

    public static<T> CommonResult validateFailed(){
        return failed(CommonCode.VALIDATE_FAILED);
    }

    public static<T> CommonResult validateFailed(String message){
        return new CommonResult<>(CommonCode.VALIDATE_FAILED.getCode(), message,null);
    }

    public static<T> CommonResult unauthorized(T data){
//        return new CommonResult<>(CommonCode.UNAUTHORIZED.getCode(), CommonCode.UNAUTHORIZED.getMessage(),data);
        return failed(CommonCode.UNAUTHORIZED, data);
    }

    public static<T> CommonResult forbidden(T data){
//        return new CommonResult<>(CommonCode.FORBIDDEN.getCode(), CommonCode.FORBIDDEN.getMessage(),data);
        return failed(CommonCode.FORBIDDEN, data);
    }
}


