package com.webdevelope.summoned.task.dto;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public class SummonedResponseDto {

    private Long id;

    private Long summonedId;

    private Long requestUserId;

    private String requestDesc;

    //1修改 2删除
    private Integer option;

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

    public Long getSummonedId() {
        return summonedId;
    }

    public void setSummonedId(Long summonedId) {
        this.summonedId = summonedId;
    }

    public Long getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(Long requestUserId) {
        this.requestUserId = requestUserId;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }
}
