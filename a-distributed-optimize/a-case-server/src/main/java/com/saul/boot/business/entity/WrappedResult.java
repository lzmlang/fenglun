package com.saul.boot.business.entity;

import com.saul.boot.business.constant.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luo_zm
 * @DESCRIPTION
 * @create 2020/4/7 16:25
 */
@ApiModel("返回结果对象")
public class WrappedResult<T> {
    private boolean successful;
    @ApiModelProperty("错误码")
    private Integer code;
    @ApiModelProperty("错误描述")
    private String msg;
    @ApiModelProperty("返回数据对象")
    private T data;

    public boolean isSuccessful() {
        return this.successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
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

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public WrappedResult(T data) {
        this.successful = true;
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    public WrappedResult() {
        this(null);
    }

    public WrappedResult(int code, String msg) {
        this.successful = true;
        this.code = code;
        this.msg = msg;
    }

    public static WrappedResult fail() {
        return fail(ResultCode.SYS_ERROR.getCode(), ResultCode.SYS_ERROR.getMsg());
    }

    public static <T> WrappedResult<T> fail(String msg) {
        return fail(ResultCode.SYS_ERROR.getCode(), msg);
    }

    public static <T> WrappedResult<T> fail(int code, String msg) {
        WrappedResult<T> r = new WrappedResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> WrappedResult<T> success() {
        return new WrappedResult();
    }

    public static <T> WrappedResult<T> success(T t) {
        WrappedResult<T> r = new WrappedResult();
        r.setData(t);
        return r;
    }

    public static <T> WrappedResult<T> success(String msg, T t) {
        WrappedResult<T> r = new WrappedResult();
        r.setMsg(msg);
        r.setData(t);
        return r;
    }
}