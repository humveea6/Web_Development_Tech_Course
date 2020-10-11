package com.webdevelope.summoned.task.model;

public class AgencyFeeDetail {
    private Long id;

    private Long time;

    private String location;

    private Integer summonedType;

    private Integer numbers;

    private Integer agencyFee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getSummonedType() {
        return summonedType;
    }

    public void setSummonedType(Integer summonedType) {
        this.summonedType = summonedType;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getAgencyFee() {
        return agencyFee;
    }

    public void setAgencyFee(Integer agencyFee) {
        this.agencyFee = agencyFee;
    }
}