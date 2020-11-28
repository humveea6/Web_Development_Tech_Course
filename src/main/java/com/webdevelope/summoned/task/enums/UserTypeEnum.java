package com.webdevelope.summoned.task.enums;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-11-28
 */
public enum UserTypeEnum {

    ADMIN(0),
    USER(1)
    ;

    private int type;

    public static boolean isAdmin(int type){
        return type == ADMIN.getType();
    }

    public static String userType(int type){
        return type == ADMIN.getType() ? "管理员":"普通用户";
    }

    UserTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}