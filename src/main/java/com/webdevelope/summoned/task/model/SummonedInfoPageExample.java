package com.webdevelope.summoned.task.model;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public class SummonedInfoPageExample extends SummonedInfoExample {

    private int pageNum;

    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
