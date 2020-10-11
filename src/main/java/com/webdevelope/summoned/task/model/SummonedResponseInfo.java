package com.webdevelope.summoned.task.model;

public class SummonedResponseInfo {
    private Long id;

    private Long requestId;

    private Long ownedUserId;

    private Long responseUserId;

    private Long createTime;

    private Integer ownerPay;

    private Integer responsePay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getOwnedUserId() {
        return ownedUserId;
    }

    public void setOwnedUserId(Long ownedUserId) {
        this.ownedUserId = ownedUserId;
    }

    public Long getResponseUserId() {
        return responseUserId;
    }

    public void setResponseUserId(Long responseUserId) {
        this.responseUserId = responseUserId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getOwnerPay() {
        return ownerPay;
    }

    public void setOwnerPay(Integer ownerPay) {
        this.ownerPay = ownerPay;
    }

    public Integer getResponsePay() {
        return responsePay;
    }

    public void setResponsePay(Integer responsePay) {
        this.responsePay = responsePay;
    }
}