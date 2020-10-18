package com.webdevelope.summoned.task.dto;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public class SummonedManageDto {

    private Long id;

    //1同意 2拒绝
    private Integer option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }
}
