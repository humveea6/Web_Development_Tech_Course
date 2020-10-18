package com.webdevelope.summoned.task.vo;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public class BaseResultVo<T> {

    private int pageNum;

    private int total;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
