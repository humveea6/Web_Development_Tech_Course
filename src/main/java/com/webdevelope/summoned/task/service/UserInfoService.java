package com.webdevelope.summoned.task.service;

import com.webdevelope.summoned.task.model.UserIdInfo;
import com.webdevelope.summoned.task.vo.ResponseVo;
import com.webdevelope.summoned.task.vo.UserInfoVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LingChen
 * Created on 2020-10-14
 */
public interface UserInfoService {
    /*
    注册
     */
    ResponseVo<String> register(UserIdInfo user);
    /*
    登录
     */
    ResponseVo<UserIdInfo> login(String username, String password);

    /**
     * 修改用户信息
     * @param id
     * @param password
     * @param phone
     * @return
     */
    int modify(long id, String password, String phone, String desc, HttpServletRequest request);

    boolean exist(String userName);

    UserInfoVo getInfo(long userId);
}
