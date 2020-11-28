package com.webdevelope.summoned.task.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-11-28
 */
@Slf4j
public enum UserTypeEnum {

    ADMIN(0),
    USER(1)
    ;

    private int type;

    public static boolean isAdmin(int type){
        log.info("UserTypeEnum type: "+type);
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
