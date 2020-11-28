package com.webdevelope.summoned.task.service;

import com.webdevelope.summoned.task.dto.SummonedManageDto;
import com.webdevelope.summoned.task.dto.SummonedResponseDto;
import com.webdevelope.summoned.task.vo.AnalyzeVo;

import java.util.List;
import java.util.Map;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public interface SummonedResponseService {

    public int addOrUpdateResponse(SummonedResponseDto summonedResponseDto);

    public int manage(SummonedManageDto summonedManageDto);

    public Map<String, AnalyzeVo> analyze();
}
