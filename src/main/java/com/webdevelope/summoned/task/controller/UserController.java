package com.webdevelope.summoned.task.controller;

import com.webdevelope.summoned.task.form.UserLoginform;
import com.webdevelope.summoned.task.form.UserRegisterform;
import com.webdevelope.summoned.task.model.LoginToken;
import com.webdevelope.summoned.task.model.UserIdInfo;
import com.webdevelope.summoned.task.service.UserInfoService;
import com.webdevelope.summoned.task.utils.CookieUtils;
import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.utils.WebResultUtil;
import com.webdevelope.summoned.task.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Base64;

/**
 * @author LingChen
 * Created on 2020-10-14
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    private static String TOKEN_NAME = "userIsLogin";

    private final Integer EXPIRE_TIME = 60*60*24*7;

    @PostMapping("/user/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterform userRegisterform,
                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("register 参数错误,{}",bindingResult.getFieldError().getDefaultMessage());
            return WebResultUtil.buildResult(
                    ResponseVo.PARAM_ERROR(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.OK);
        }
        UserIdInfo user = new UserIdInfo();
        BeanUtils.copyProperties(userRegisterform,user);
        user.setUserGrade(1);
        ResponseVo<String> register = userInfoService.register(user);
        return WebResultUtil.buildResult(ResponseVo.success(register),HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginform userLoginform,
                                        BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return WebResultUtil.buildResult(
                    ResponseVo.PARAM_ERROR(bindingResult.getFieldError().getDefaultMessage()),HttpStatus.OK);
        }

        ResponseVo<UserIdInfo> userResponseVo =
                userInfoService.login(userLoginform.getUsername(), userLoginform.getPassword());

        UserIdInfo user = userResponseVo.getData();

        //cookie
        if(userResponseVo.getStatus().equals(200) && user != null){
            String domain;
            log.info("login serverName:{}",request.getServerName());
            domain = request.getServerName();

            CookieUtils.saveCookie(
                    response,
                    TOKEN_NAME,
                    buildToken(user),
                    EXPIRE_TIME,
                    domain,
                    "/",
                    false
            );
        }

        return WebResultUtil.buildResult(ResponseVo.success(),HttpStatus.OK);
    }

    public String buildToken(UserIdInfo userIdInfo) {
        LoginToken approvalLoginToken = new LoginToken.Builder()
                .tokenName(TOKEN_NAME)
                .userId(userIdInfo.getId())
                .userName(userIdInfo.getUserName())
                .loginTime(System.currentTimeMillis())
                .build();
        return Base64.getEncoder().encodeToString(JsonUtils.toJson(approvalLoginToken).getBytes());
    }
}
