package com.webdevelope.summoned.task.vo;

import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.model.SummonedRequestInfo;

import java.util.List;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public class SummonedDetailVo {

    private SummonedInfo summonedInfo;

    private List<SummonedRequestInfo> requestInfoList;

    public SummonedInfo getSummonedInfo() {
        return summonedInfo;
    }

    public void setSummonedInfo(SummonedInfo summonedInfo) {
        this.summonedInfo = summonedInfo;
    }

    public List<SummonedRequestInfo> getRequestInfoList() {
        return requestInfoList;
    }

    public void setRequestInfoList(List<SummonedRequestInfo> requestInfoList) {
        this.requestInfoList = requestInfoList;
    }
}
