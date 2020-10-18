package com.webdevelope.summoned.task.service.Impl;

import com.webdevelope.summoned.task.form.SummonedRequestForm;
import com.webdevelope.summoned.task.mappers.SummonedInfoMapper;
import com.webdevelope.summoned.task.mappers.SummonedRequestInfoMapper;
import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.model.SummonedInfoExample;
import com.webdevelope.summoned.task.model.SummonedRequestInfo;
import com.webdevelope.summoned.task.model.SummonedRequestInfoExample;
import com.webdevelope.summoned.task.service.SummonedRequestService;
import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.vo.SummonedDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.webdevelope.summoned.task.enums.SummonedStatusEnum.DELETE;
import static com.webdevelope.summoned.task.enums.SummonedStatusEnum.WAIT_FOR_RESPONSE;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
@Service
@Slf4j
public class SummonedRequestServiceImpl implements SummonedRequestService {

    @Autowired
    private SummonedInfoMapper summonedInfoMapper;

    @Autowired
    private SummonedRequestInfoMapper summonedRequestInfoMapper;

    @Override
    public int addOrUpdateRequest(SummonedRequestForm form) {
        if(form.getId() != null){
            SummonedInfo summonedInfo = summonedInfoMapper.selectByPrimaryKey(form.getId());
            if(summonedInfo.getStatus().equals(WAIT_FOR_RESPONSE.getStatus())){
                if(form.getOption().equals(2)){
                    summonedInfo.setStatus(DELETE.getStatus());
                }
                else{
                    BeanUtils.copyProperties(form,summonedInfo);
                    log.info("addOrUpdateRequest copy, form: {},summon: {}", JsonUtils.toJson(form),JsonUtils.toJson(summonedInfo));
                }
                int i = summonedInfoMapper.updateByPrimaryKeySelective(summonedInfo);
                if(i > 0){
                    return 1;
                }
                else {
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
        else{
            SummonedInfo summonedInfo = new SummonedInfo();
            BeanUtils.copyProperties(form,summonedInfo);
            int i = summonedInfoMapper.insertSelective(summonedInfo);
            if(i > 0){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    @Override
    public List<SummonedInfo> getSummonedList(Long userId, Integer type, String search) {
        SummonedInfoExample summonedInfoExample = new SummonedInfoExample();
        SummonedInfoExample.Criteria criteria = summonedInfoExample.createCriteria();
        if(userId != null){
            criteria.andOwnUserIdEqualTo(userId);
        }
        if(type != null){
            criteria.andSummonedTypeEqualTo(type);
        }
        if(!StringUtils.isEmpty(search)){
            criteria.andSummonedNameLike("%"+search+"%");
        }
        return summonedInfoMapper.selectByExample(summonedInfoExample);
    }

    @Override
    public SummonedDetailVo getSummonedDetail(Long userId, Long summonedId) {
        SummonedDetailVo summonedDetailVo = new SummonedDetailVo();
        if(summonedId == null){
            return summonedDetailVo;
        }
        SummonedInfo summonedInfo = summonedInfoMapper.selectByPrimaryKey(summonedId);
        summonedDetailVo.setSummonedInfo(summonedInfo);
        if(userId != null && userId.equals(summonedInfo.getOwnUserId())){
            SummonedRequestInfoExample example = new SummonedRequestInfoExample();
            SummonedRequestInfoExample.Criteria criteria = example.createCriteria();
            criteria.andSummonedIdEqualTo(summonedId);
            List<SummonedRequestInfo> summonedRequestInfoList = summonedRequestInfoMapper.selectByExample(example);
            summonedDetailVo.setRequestInfoList(summonedRequestInfoList);
        }
        return summonedDetailVo;
    }
}
