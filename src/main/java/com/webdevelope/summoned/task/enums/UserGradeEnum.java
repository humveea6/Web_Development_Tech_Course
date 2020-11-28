package com.webdevelope.summoned.task.enums;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-11-28
 */
public enum UserGradeEnum {

    SIMPLE(0),
    VIP(1),
    DIAMOND(2)
    ;

    private int type;

    public static String userGrade(int grade){
        if(grade == SIMPLE.getType()){
            return "一般会员";
        }
        else if(grade == VIP.getType()){
            return "重要会员";
        }
        else{
            return "砖石会员";
        }
    }

    UserGradeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
