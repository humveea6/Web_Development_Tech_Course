package com.webdevelope.summoned.task.service.Impl;

import com.webdevelope.summoned.task.form.SummonedRequestForm;
import com.webdevelope.summoned.task.mappers.SummonedInfoMapper;
import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.model.SummonedInfoExample;
import com.webdevelope.summoned.task.service.SummonedRequestService;
import com.webdevelope.summoned.task.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
}
