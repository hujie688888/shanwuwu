package com.example.shanwuwu.utils;

public enum BusinessCode implements IErrorCode {

    FAILURE(2000,"订单插入失败"),
    ;

    long code;
    String message;

    BusinessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

