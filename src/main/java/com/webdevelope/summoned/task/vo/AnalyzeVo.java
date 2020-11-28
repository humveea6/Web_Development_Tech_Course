package com.webdevelope.summoned.task.vo;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-11-28
 */
public class AnalyzeVo {

    private int count;

    private long total;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public AnalyzeVo(int count, long total) {
        this.count = count;
        this.total = total;
    }

    public AnalyzeVo() {
    }
}
