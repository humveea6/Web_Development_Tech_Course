package com.webdevelope.summoned.task.controller;

import com.webdevelope.summoned.task.annotations.SeniorPermissionRequired;
import com.webdevelope.summoned.task.enums.UserTypeEnum;
import com.webdevelope.summoned.task.form.UserInfoModifyForm;
import com.webdevelope.summoned.task.form.UserLoginform;
import com.webdevelope.summoned.task.form.UserRegisterform;
import com.webdevelope.summoned.task.model.LoginToken;
import com.webdevelope.summoned.task.model.UserIdInfo;
import com.webdevelope.summoned.task.service.UserInfoService;
import com.webdevelope.summoned.task.utils.CookieUtils;
import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.utils.WebResultUtil;
import com.webdevelope.summoned.task.vo.ResponseVo;
import com.webdevelope.summoned.task.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LingChen
 * Created on 2020-10-14
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    private static String TOKEN_NAME = "userIsLogIn";

    private final Integer EXPIRE_TIME = 60*60*24*7;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterform userRegisterform,
                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("register 参数错误,{}",bindingResult.getFieldError().getDefaultMessage());
            return WebResultUtil.buildResult(
                    ResponseVo.PARAM_ERROR(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.OK);
        }
        UserIdInfo user = new UserIdInfo();
        BeanUtils.copyProperties(userRegisterform,user);
        log.info("params: "+ JsonUtils.toJson(user));
        user.setUserGrade(1);
        ResponseVo<String> register = userInfoService.register(user);
        return WebResultUtil.buildResult(ResponseVo.success(register),HttpStatus.OK);
    }

    @GetMapping("/exist")
    public ResponseEntity<String> userNameExist(String userName){
        boolean exist = userInfoService.exist(userName);
        if(exist){
            return WebResultUtil.buildResult(ResponseVo.success("exist"),HttpStatus.OK);
        }
        else{
            return WebResultUtil.buildResult(ResponseVo.success("Not exist"),HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginform userLoginform,
                                        BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return WebResultUtil.buildResult(
                    ResponseVo.PARAM_ERROR(bindingResult.getFieldError().getDefaultMessage()),HttpStatus.OK);
        }

        ResponseVo<UserIdInfo> userResponseVo =
                userInfoService.login(userLoginform.getUsername(), userLoginform.getPassword());

        log.info("login service response: "+JsonUtils.toJson(userResponseVo));

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
        else{
            return WebResultUtil.buildResult(ResponseVo.USER_NOT_EXIST_OR_PASSWORD_ERROR(),HttpStatus.OK);
        }

        Map<String,Object> resMap = new HashMap<>();
        UserInfoVo info = userInfoService.getInfo(user.getId());
        resMap.put("user",info);

        if(user.getUserType() != null && UserTypeEnum.isAdmin(user.getUserType())){
            resMap.put("userType","admin");
        }
        else{
            resMap.put("userType","user");
        }

        return WebResultUtil.buildResult(ResponseVo.success(resMap),HttpStatus.OK);
    }

    @GetMapping("/info")
    @SeniorPermissionRequired
    public ResponseEntity<String> info(Long userId){
        if(userId == null){
            return WebResultUtil.buildResult(ResponseVo.fail("userId is null!"),HttpStatus.OK);
        }
        UserInfoVo info = userInfoService.getInfo(userId);
        if(info == null){
            return WebResultUtil.buildResult(ResponseVo.fail("user not exist!"),HttpStatus.OK);
        }
        return WebResultUtil.buildResult(ResponseVo.success(info),HttpStatus.OK);
    }

    @SeniorPermissionRequired
    @PostMapping("/modify")
    public ResponseEntity<String> modifyInfo(@Valid @RequestBody UserInfoModifyForm userInfoModifyForm,HttpServletRequest request){
        int modify = userInfoService.modify(userInfoModifyForm.getId(),
                userInfoModifyForm.getPassword(), userInfoModifyForm.getCellphoneNumber(),userInfoModifyForm.getDesc(),request);
        if(modify > 0){
            return WebResultUtil.buildResult(ResponseVo.success(),HttpStatus.OK);
        }
        else{
            return WebResultUtil.buildResult(ResponseVo.permissionDenied("非法请求！"),HttpStatus.OK);
        }
    }

    @SeniorPermissionRequired
    @GetMapping("/test")
    public ResponseEntity<String> annotationTest(){

        return WebResultUtil.buildResult(ResponseVo.success("登录成功！"),HttpStatus.OK);
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
