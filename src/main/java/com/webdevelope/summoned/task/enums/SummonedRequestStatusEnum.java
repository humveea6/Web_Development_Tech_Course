package com.webdevelope.summoned.task.enums;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public enum SummonedRequestStatusEnum {
    PENDING(0),
    AGREE(1),
    REJECT(2),
    CANCEL(3)
    ;

    private int status;

    public int getStatus() {
        return status;
    }

    SummonedRequestStatusEnum(int status) {
        this.status = status;
    }
}
