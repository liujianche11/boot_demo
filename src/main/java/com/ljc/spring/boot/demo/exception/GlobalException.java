package com.ljc.spring.boot.demo.exception;

public class GlobalException extends RuntimeException {

    private String code;
    private String msg;

    public GlobalException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message, String code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message, Throwable cause, String code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(Throwable cause, String code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }
}
