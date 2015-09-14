package com.jpa.dto;

/**
 * Created by Mang on 15/9/13.
 */
public class RestResponseData<T extends Object> {
    private String code;
    private T message;

    public RestResponseData() {
    }

    public RestResponseData(String code, T message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
