package com.webdevelope.summoned.task.model;

public class SummonedInfo {
    private Long id;

    private Long ownUserId;

    private Integer summonedType;

    private String summonedName;

    private String summonedDesc;

    private Integer wantedNumber;

    private Long finishTime;

    private String descPicture;

    private Long createTime;

    private Long updateTime;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnUserId() {
        return ownUserId;
    }

    public void setOwnUserId(Long ownUserId) {
        this.ownUserId = ownUserId;
    }

    public Integer getSummonedType() {
        return summonedType;
    }

    public void setSummonedType(Integer summonedType) {
        this.summonedType = summonedType;
    }

    public String getSummonedName() {
        return summonedName;
    }

    public void setSummonedName(String summonedName) {
        this.summonedName = summonedName == null ? null : summonedName.trim();
    }

    public String getSummonedDesc() {
        return summonedDesc;
    }

    public void setSummonedDesc(String summonedDesc) {
        this.summonedDesc = summonedDesc == null ? null : summonedDesc.trim();
    }

    public Integer getWantedNumber() {
        return wantedNumber;
    }

    public void setWantedNumber(Integer wantedNumber) {
        this.wantedNumber = wantedNumber;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public String getDescPicture() {
        return descPicture;
    }

    public void setDescPicture(String descPicture) {
        this.descPicture = descPicture == null ? null : descPicture.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}