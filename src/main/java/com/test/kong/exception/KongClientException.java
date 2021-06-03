package com.test.kong.exception;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 15:59
 * @version: 1.0
 */
public class KongClientException extends RuntimeException {

    private int code;

    private String error;

    public KongClientException(String message) {
        super(message);
    }

    public KongClientException(String message, int code, String error) {
        super(message);
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }
}
