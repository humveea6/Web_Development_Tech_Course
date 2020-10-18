package com.webdevelope.summoned.task.form;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-17
 */
public class SummonedRequestForm {

    private Long id;

    private Long ownUserId;

    private Integer summonedType;

    private String summonedName;

    private String summonedDesc;

    private String descPicture;

    private Integer wantedNumber;

    private Long finishTime;

    //1修改 2删除
    private Integer option;

    public String getDescPicture() {
        return descPicture;
    }

    public void setDescPicture(String descPicture) {
        this.descPicture = descPicture;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

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
        this.summonedName = summonedName;
    }

    public String getSummonedDesc() {
        return summonedDesc;
    }

    public void setSummonedDesc(String summonedDesc) {
        this.summonedDesc = summonedDesc;
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
}
