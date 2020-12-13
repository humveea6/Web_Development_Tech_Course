package com.webdevelope.summoned.task.controller;

import com.webdevelope.summoned.task.annotations.AdminPermissionRequired;
import com.webdevelope.summoned.task.service.SummonedRequestService;
import com.webdevelope.summoned.task.service.SummonedResponseService;
import com.webdevelope.summoned.task.service.UserInfoService;
import com.webdevelope.summoned.task.utils.WebResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-11-28
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SummonedRequestService summonedRequestService;

    @Autowired
    private SummonedResponseService summonedResponseService;

    @GetMapping("/user/list")
    @AdminPermissionRequired
    public ResponseEntity<String> getUserList(){
        return WebResultUtil.buildResult(userInfoService.getUserList(), HttpStatus.OK);
    }

    @GetMapping("/summonedList")
    @AdminPermissionRequired
    public ResponseEntity<String> getSummoned(){
        return WebResultUtil.buildResult(summonedRequestService.getAllsummoned(), HttpStatus.OK);
    }

    @GetMapping("/responseList")
    @AdminPermissionRequired
    public ResponseEntity<String> getResponse(){
        return WebResultUtil.buildResult(summonedRequestService.getAllRequestList(), HttpStatus.OK);
    }

    @GetMapping("/analyze")
    @AdminPermissionRequired
    public ResponseEntity<String> getAnalyze(){
        return WebResultUtil.buildResult(summonedResponseService.analyze(), HttpStatus.OK);
    }
}
