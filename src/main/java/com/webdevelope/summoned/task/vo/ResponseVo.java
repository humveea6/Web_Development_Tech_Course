package com.webdevelope.summoned.task.vo;

import static com.webdevelope.summoned.task.enums.ResponseEnum.*;

/**
 * @author LingChen 
 * Created on 2020-05-11
 */
public class ResponseVo<T> {

    private Integer status;

    private String msg;

    private T data;

    public static <T> ResponseVo<T> PARAM_ERROR(T data) {
        return new ResponseVo<T>(PARAM_ERROR.getCode(), PARAM_ERROR.getDesc(),data);
    }

    public static <T> ResponseVo<T> USER_NOT_EXIST_OR_PASSWORD_ERROR() {
        return new ResponseVo<T>(USER_NOT_EXIST_OR_PASSWORD_ERROR.getCode(), USER_NOT_EXIST_OR_PASSWORD_ERROR.getDesc());
    }

    public static <T> ResponseVo<T> SSONeedLogin() {
        return new ResponseVo<T>(SSO_NEED_LOGIN.getCode(), SSO_NEED_LOGIN.getDesc());
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(SUCCESS.getCode(), SUCCESS.getDesc(), data);
    }

    public static <T> ResponseVo<T> permissionDenied(T data) {
        return new ResponseVo<T>(PERMISSION_DENIED.getCode(), PERMISSION_DENIED.getDesc(), data);
    }

    public static <T> ResponseVo<T> success() {
        return new ResponseVo<T>(SUCCESS.getCode(), SUCCESS.getDesc());
    }

    public static <T> ResponseVo<T> serverError() {
        return new ResponseVo<T>(SERVER_ERROR.getCode(), SERVER_ERROR.getDesc());
    }

    public static <T> ResponseVo<T> success(Integer code, String desc) {
        return new ResponseVo<T>(code, desc);
    }

    public static <T> ResponseVo<T> fail(Integer code, String desc) {
        return new ResponseVo<T>(code, desc);
    }

    public static <T> ResponseVo<T> fail(Integer code, String desc,T data) {
        return new ResponseVo<T>(code, desc,data);
    }

    public static <T> ResponseVo<T> fail(T data) {
        return new ResponseVo<T>(SERVER_ERROR.getCode(), SERVER_ERROR.getDesc(), data);
    }

    public static <T> ResponseVo<T> fail() {
        return new ResponseVo<T>(SERVER_ERROR.getCode(), SERVER_ERROR.getDesc());
    }

    public ResponseVo() {
    }

    public ResponseVo(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
