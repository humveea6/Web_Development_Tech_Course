package com.webdevelope.summoned.task.form;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-17
 */
public class UserInfoModifyForm {

    private Long id;

    private String cellphoneNumber;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
