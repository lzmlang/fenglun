package com.saul.boot.business.constant;

/**
 * @author luo_zm
 * @DESCRIPTION
 * @create 2020/4/7 16:26
 */
public enum ResultCode {
    SUCCESS(200, "请求成功"),
    SYS_ERROR(-1, "系统异常，请联系管理员"),
    AUTH_ERROR(1000, "认证失败"),
    LOGIN_ERROR(1001, "登录失败"),
    LOGIN_UNKNOWN_ACCOUNT(1002, "找不到用户"),
    LOGIN_INCORRECT_CREDENTIALS(1003, "密码错误"),
    LOGIN_LOCKED_ACCOUNT(1004, "冻结的账户"),
    LOGIN_LOGINED_ERROR(1005, "已经登录"),
    LOGIN_NOT_LOGIN_ERROR(1006, "未登录"),
    PARAM_VALIDATE_ERROR(2001, "参数校验错误"),
    SQL_ERROR(4001, "sql操作异常"),
    REDIS_ERROR(5001, "redis操作异常"),
    NULL_ERROR(7001, "系统错误:空指针异常-内存中存在调用空对象的方法"),
    FILE_ERROR(6001, "文件操作异常");

    private Integer code;
    private String msg;

    private ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

