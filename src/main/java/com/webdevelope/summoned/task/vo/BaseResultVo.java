package com.webdevelope.summoned.task.vo;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public class BaseResultVo<T> {

    private int pageNum;

    private int pageSize;

    private T data;

    public BaseResultVo() {
    }

    public BaseResultVo(T data) {
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
