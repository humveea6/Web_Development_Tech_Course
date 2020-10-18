package com.webdevelope.summoned.task.controller;

import com.webdevelope.summoned.task.annotations.SeniorPermissionRequired;
import com.webdevelope.summoned.task.dto.SummonedManageDto;
import com.webdevelope.summoned.task.dto.SummonedResponseDto;
import com.webdevelope.summoned.task.service.SummonedResponseService;
import com.webdevelope.summoned.task.utils.WebResultUtil;
import com.webdevelope.summoned.task.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-18
 */
@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private SummonedResponseService summonedResponseService;

    @SeniorPermissionRequired
    @PostMapping("/addOrUpdate")
    public ResponseEntity<String> addOrUpdateResponse(SummonedResponseDto summonedResponseDto){
        int i = summonedResponseService.addOrUpdateResponse(summonedResponseDto);
        if(i > 0){
            return WebResultUtil.buildResult(ResponseVo.success(), HttpStatus.OK);
        }
        else{
            return WebResultUtil.buildResult(ResponseVo.fail(),HttpStatus.OK);
        }
    }

    @SeniorPermissionRequired
    @PostMapping("/addOrUpdate")
    public ResponseEntity<String> manageSummoned(SummonedManageDto summonedManageDto){
        int i = summonedResponseService.manage(summonedManageDto);
        if(i > 0){
            return WebResultUtil.buildResult(ResponseVo.success(), HttpStatus.OK);
        }
        else{
            return WebResultUtil.buildResult(ResponseVo.fail(),HttpStatus.OK);
        }
    }
}
