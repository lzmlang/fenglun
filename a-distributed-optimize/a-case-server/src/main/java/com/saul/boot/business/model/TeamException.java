package com.saul.boot.business.model;

import lombok.Getter;

@Getter
public class TeamException extends RuntimeException {

    private static final long serialVersionUID = 5332920709873321426L;

    /**
     * 状态码
     */
    private int code;

    public TeamException(int code, String message) {
        super(message);
        this.code = code;
    }

    public TeamException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public TeamException(String msg) {
        super(msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
