package com.webdevelope.summoned.task.service.Impl;

import com.webdevelope.summoned.task.dto.PageDto;
import com.webdevelope.summoned.task.form.SummonedRequestForm;
import com.webdevelope.summoned.task.mappers.SummonedInfoMapper;
import com.webdevelope.summoned.task.mappers.SummonedRequestInfoMapper;
import com.webdevelope.summoned.task.model.*;
import com.webdevelope.summoned.task.service.SummonedRequestService;
import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.vo.BaseResultVo;
import com.webdevelope.summoned.task.vo.SummonedDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public BaseResultVo getSummonedList(Long userId, Integer type, String search, PageDto pageDto) {
        SummonedInfoPageExample example = new SummonedInfoPageExample();
        SummonedInfoExample.Criteria criteria = example.createCriteria();
        if(userId != null){
            criteria.andOwnUserIdEqualTo(userId);
        }
        if(type != null){
            criteria.andSummonedTypeEqualTo(type);
        }
        if(!StringUtils.isEmpty(search)){
            criteria.andSummonedNameLike("%"+search+"%");
        }
        long count = summonedInfoMapper.countByExample(example);
        example.setPageNum(Math.max(pageDto.getPageNum()-1,0) * pageDto.getPageSize());
        example.setPageSize(pageDto.getPageSize());
        example.setOrderByClause("id asc");
        List<SummonedInfo> summonedInfoList = summonedInfoMapper.selectByPageExample(example);

        BaseResultVo resultVo = new BaseResultVo(summonedInfoList);
        resultVo.setPageNum(pageDto.getPageNum());
        resultVo.setTotal((int)count);
        return resultVo;
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

    @Override
    public List<SummonedRequestInfo> getRequestList(Long userId) {
        SummonedRequestInfoExample example = new SummonedRequestInfoExample();
        SummonedRequestInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRequestUserIdEqualTo(userId);
        return summonedRequestInfoMapper.selectByExample(example);
    }

    @Override
    public List<SummonedInfo> getSummonedList(long userId) {
        SummonedRequestInfoExample example = new SummonedRequestInfoExample();
        SummonedRequestInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRequestUserIdEqualTo(userId);
        List<SummonedRequestInfo> summonedRequestInfos = summonedRequestInfoMapper.selectByExample(example);
        Set<Long> ids = summonedRequestInfos.stream().map(SummonedRequestInfo::getSummonedId).collect(Collectors.toSet());

        SummonedInfoExample summonedInfoExample = new SummonedInfoExample();
        SummonedInfoExample.Criteria criteria1 = summonedInfoExample.createCriteria();
        criteria1.andIdIn(new ArrayList<>(ids));
        return summonedInfoMapper.selectByExample(summonedInfoExample);
    }

    @Override
    public List<SummonedInfo> getAllsummoned() {
        return summonedInfoMapper.selectByExample(new SummonedInfoExample());
    }

    @Override
    public List<SummonedRequestInfo> getAllRequestList() {
        return summonedRequestInfoMapper.selectByExample(new SummonedRequestInfoExample());
    }
}
