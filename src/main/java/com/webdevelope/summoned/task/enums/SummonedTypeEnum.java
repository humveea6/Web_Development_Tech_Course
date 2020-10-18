package com.webdevelope.summoned.task.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-17
 */
public enum SummonedTypeEnum {
    TECH("技术交流",1),
    STUDY("学业探讨",2),
    SOCIAL_PRA("社会实践",3),
    VOLUNTEER("公益志愿者",4),
    TRIP("游玩",5),
    OTHERS("其他",6)
    ;

    private String desc;

    private int code;

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    SummonedTypeEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public static List<SummonedTypeEnum> getAllEnums(){
        List<SummonedTypeEnum> list = new ArrayList<>();
        for (SummonedTypeEnum value : values()) {
            list.add(value);
        }
        return list;
    }
}
