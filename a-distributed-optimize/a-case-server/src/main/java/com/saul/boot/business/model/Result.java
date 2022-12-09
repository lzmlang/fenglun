package com.saul.boot.business.model;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author luo_zm
 * @DESCRIPTION 结果统一返回
 * @create 2020/9/5 15:42
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7136275879390165308L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回值
     */
    private T data;

    /**
     * 返回信息
     */
    private String msg;

    public Result() {
    }

    private Result(T data, String msg, int code) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功返回
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>(null, "成功", HttpStatus.OK.value());
    }

    /**
     * 成功返回
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String msg) {
        return new Result<T>(null, msg, HttpStatus.OK.value());
    }

    /**
     * 成功返回
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data, String msg) {
        return new Result<T>(data, msg, HttpStatus.OK.value());
    }

    /**
     * 失败返回
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(String msg, HttpStatus code) {
        return new Result<T>(null, msg, code.value());
    }

    /**
     * 失败返回
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(String msg) {
        return new Result<T>(null, msg, HttpStatus.EXPECTATION_FAILED.value());
    }

    /**
     * 其他返回
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> restResult(String msg, HttpStatus code) {
        return new Result<T>(null, msg, code.value());
    }

    /**
     * 其他返回
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> restResult(T data, String msg, HttpStatus code) {
        return new Result<T>(data, msg, code.value());
    }
}
