package com.webdevelope.summoned.task.enums;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public enum SummonedStatusEnum {
    DONE(1),
    WAIT_FOR_RESPONSE(0),
    RESPONSE_NOT_ENOUGH(3),
    CANCEL(4),
    TIME_OUT(5),
    DELETE(6)
    ;

    private int status;

    public int getStatus() {
        return status;
    }

    SummonedStatusEnum(int status) {
        this.status = status;
    }
}
