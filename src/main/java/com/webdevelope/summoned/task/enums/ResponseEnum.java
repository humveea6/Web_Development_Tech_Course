package com.webdevelope.summoned.task.enums;

/**
 * @author LingChen
 * Created on 2020-05-11
 */
public enum ResponseEnum {

    PARAM_ERROR(400,"PARAM_ERROR"),
    SSO_NEED_LOGIN(401, "SSO_NEED_LOGIN"),
    SUCCESS(200, "OK"),
    SERVER_ERROR(500, "SERVER_ERROR_OCCUR"),
    PERMISSION_DENIED(403,"PERMISSION_DENIED"),
    LOGOUT_SUCCESS(200, "LOGOUT_SUCCESS"),
    HASHTAG_IDS_EMPTY(420,"HASHTAG_IDS_EMPTY"),
    PARAMS_ILLEGAL(421,"PARAMS_ILLEGAL"),
    ITEM_IDS_EMPTY(422,"ITEM_IDS_EMPTY"),
    USER_NOT_EXIST_OR_PASSWORD_ERROR(423,"USER_NOT_EXIST_OR_PASSWORD_ERROR");

    private Integer code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
