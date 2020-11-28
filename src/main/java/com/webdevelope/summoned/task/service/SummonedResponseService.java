package com.webdevelope.summoned.task.service;

import com.webdevelope.summoned.task.dto.SummonedManageDto;
import com.webdevelope.summoned.task.dto.SummonedResponseDto;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
public interface SummonedResponseService {

    public int addOrUpdateResponse(SummonedResponseDto summonedResponseDto);

    public int manage(SummonedManageDto summonedManageDto);
}
