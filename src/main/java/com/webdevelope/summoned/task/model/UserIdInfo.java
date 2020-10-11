package com.webdevelope.summoned.task.model;

public class UserIdInfo {
    private Long id;

    private String userName;

    private String password;

    private Integer userType;

    private String realName;

    private Integer certificateType;

    private Long certificateNumber;

    private String cellphoneNumber;

    private Integer userGrade;

    private String userDesc;

    private String registerCity;

    private Long registerTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public Long getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(Long certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber == null ? null : cellphoneNumber.trim();
    }

    public Integer getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }

    public String getRegisterCity() {
        return registerCity;
    }

    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity == null ? null : registerCity.trim();
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}