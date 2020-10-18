package com.webdevelope.summoned.task.service;

import com.webdevelope.summoned.task.form.SummonedRequestForm;
import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.vo.SummonedDetailVo;

import java.util.List;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public interface SummonedRequestService {

    public int addOrUpdateRequest(SummonedRequestForm form);

    public List<SummonedInfo> getSummonedList(Long userId,Integer type,String search);

    public SummonedDetailVo getSummonedDetail(Long userId,Long summonedId);
}
