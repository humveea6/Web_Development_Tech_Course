package com.webdevelope.summoned.task.service.Impl;

import com.webdevelope.summoned.task.dto.SummonedManageDto;
import com.webdevelope.summoned.task.dto.SummonedResponseDto;
import com.webdevelope.summoned.task.mappers.SummonedInfoMapper;
import com.webdevelope.summoned.task.mappers.SummonedRequestInfoMapper;
import com.webdevelope.summoned.task.mappers.SummonedResponseInfoMapper;
import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.model.SummonedRequestInfo;
import com.webdevelope.summoned.task.model.SummonedRequestInfoExample;
import com.webdevelope.summoned.task.model.SummonedResponseInfo;
import com.webdevelope.summoned.task.service.SummonedResponseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.webdevelope.summoned.task.enums.SummonedRequestStatusEnum.*;
import static com.webdevelope.summoned.task.enums.SummonedRequestStatusEnum.CANCEL;
import static com.webdevelope.summoned.task.enums.SummonedStatusEnum.*;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
@Service
public class SummonedResponseServiceImpl implements SummonedResponseService {

    @Autowired
    private SummonedInfoMapper summonedInfoMapper;

    @Autowired
    private SummonedRequestInfoMapper summonedRequestInfoMapper;

    @Autowired
    private SummonedResponseInfoMapper summonedResponseInfoMapper;

    @Override
    public int addOrUpdateResponse(SummonedResponseDto summonedResponseDto) {
        SummonedInfo summonedInfo = summonedInfoMapper.selectByPrimaryKey(summonedResponseDto.getSummonedId());
        if(!summonedInfo.getStatus().equals(WAIT_FOR_RESPONSE.getStatus()) && !summonedInfo.getStatus().equals(RESPONSE_NOT_ENOUGH.getStatus())){
            return -1;
        }

        if(summonedResponseDto.getId() != null){
            SummonedRequestInfo summonedRequestInfo = summonedRequestInfoMapper.selectByPrimaryKey(summonedResponseDto.getId());
            if(summonedRequestInfo != null && summonedRequestInfo.getStatus().equals(PENDING.getStatus())){
                BeanUtils.copyProperties(summonedResponseDto,summonedRequestInfo);
                if(summonedResponseDto.getOption().equals(2)){
                    summonedRequestInfo.setStatus(CANCEL.getStatus());
                }
                summonedRequestInfo.setUpdateTime(System.currentTimeMillis());
                return summonedRequestInfoMapper.updateByPrimaryKeySelective(summonedRequestInfo);
            }
        }
        else{
            SummonedRequestInfo summonedRequestInfo = new SummonedRequestInfo();
            BeanUtils.copyProperties(summonedResponseDto,summonedRequestInfo);
            summonedRequestInfo.setCreateTime(System.currentTimeMillis());
            return summonedRequestInfoMapper.insertSelective(summonedRequestInfo);
        }
        return -1;
    }

    @Override
    public int manage(SummonedManageDto summonedManageDto) {
        SummonedRequestInfo summonedRequestInfo = new SummonedRequestInfo();
        summonedRequestInfo.setId(summonedManageDto.getId());
        if(summonedManageDto.getOption().equals(1)){
            summonedRequestInfo.setStatus(AGREE.getStatus());
        }
        else{
            summonedRequestInfo.setStatus(REJECT.getStatus());
        }
        int i = summonedRequestInfoMapper.updateByPrimaryKeySelective(summonedRequestInfo);

        if(i > 0 && summonedManageDto.getOption().equals(1)){
            SummonedRequestInfo info = summonedRequestInfoMapper.selectByPrimaryKey(summonedManageDto.getId());
            SummonedInfo summonedInfo = summonedInfoMapper.selectByPrimaryKey(info.getSummonedId());

            SummonedRequestInfoExample example = new SummonedRequestInfoExample();
            SummonedRequestInfoExample.Criteria criteria = example.createCriteria();
            criteria.andSummonedIdEqualTo(summonedManageDto.getId())
                    .andStatusEqualTo(AGREE.getStatus());
            long count = summonedRequestInfoMapper.countByExample(example);
            if(summonedInfo.getWantedNumber().equals((int)count)){
                summonedInfo.setStatus(DONE.getStatus());
            }
            else if(count == 1L){
                summonedInfo.setStatus(RESPONSE_NOT_ENOUGH.getStatus());
            }
            summonedInfoMapper.updateByPrimaryKeySelective(summonedInfo);

            SummonedResponseInfo summonedResponseInfo = new SummonedResponseInfo();
            summonedResponseInfo.setOwnerPay(3);
            summonedResponseInfo.setResponsePay(1);
            summonedResponseInfo.setOwnedUserId(summonedInfo.getOwnUserId());
            summonedResponseInfo.setRequestId(info.getId());
            summonedResponseInfo.setResponseUserId(info.getRequestUserId());
            summonedResponseInfo.setCreateTime(System.currentTimeMillis());
            int insert = summonedResponseInfoMapper.insertSelective(summonedResponseInfo);
            return 1;
        }
        else if(i > 0 &&summonedManageDto.getOption().equals(2)){
            return 1;
        }
        return -1;
    }
}
