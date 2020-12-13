package com.webdevelope.summoned.task.service.Impl;

import com.webdevelope.summoned.task.enums.UserGradeEnum;
import com.webdevelope.summoned.task.enums.UserTypeEnum;
import com.webdevelope.summoned.task.exceptions.SeniorPermissionRequiredException;
import com.webdevelope.summoned.task.mappers.UserIdInfoMapper;
import com.webdevelope.summoned.task.model.LoginToken;
import com.webdevelope.summoned.task.model.UserIdInfo;
import com.webdevelope.summoned.task.model.UserIdInfoExample;
import com.webdevelope.summoned.task.service.UserInfoService;
import com.webdevelope.summoned.task.utils.CookieUtils;
import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.vo.ResponseVo;
import com.webdevelope.summoned.task.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author LingChen
 * Created on 2020-10-14
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserIdInfoMapper userIdInfoMapper;

    private final String APPROVAL_TOKEN_NAME = "userIsLogIn";

    @Override
    public ResponseVo<String> register(UserIdInfo user) {
        //username不重复
        log.info("register enter");
        log.info("register params: "+ JsonUtils.toJson(user));
        UserIdInfoExample userIdInfoExample = new UserIdInfoExample();
        UserIdInfoExample.Criteria criteria = userIdInfoExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        if (userIdInfoMapper.countByExample(userIdInfoExample) > 0){
            return ResponseVo.fail("用户名已存在！");
        }

        log.info("register ok here");

        //MD5 摘要
        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(s);

        //写入数据库
        int resultCount = userIdInfoMapper.insertSelective(user);
        if (resultCount == 0){
            return ResponseVo.fail("注册出错！");
        }

        return ResponseVo.success("注册成功！");
    }

    @Override
    public ResponseVo<UserIdInfo> login(String username, String password) {
        UserIdInfoExample userIdInfoExample = new UserIdInfoExample();
        UserIdInfoExample.Criteria criteria = userIdInfoExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<UserIdInfo> userList = userIdInfoMapper.selectByExample(userIdInfoExample);
        log.info("userlist :"+JsonUtils.toJson(userList));
        if(CollectionUtils.isEmpty(userList)){
            //return error
            return ResponseVo.USER_NOT_EXIST_OR_PASSWORD_ERROR();
        }
        UserIdInfo user = userList.get(0);
        if(!user.getPassword().equalsIgnoreCase(DigestUtils.
                md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            //password error
            log.info("pwd is: "+DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
            return ResponseVo.USER_NOT_EXIST_OR_PASSWORD_ERROR();
        }
        user.setPassword("");

        return ResponseVo.success(user);
    }

    @Override
    public int modify(long id, String password, String phone, String desc, HttpServletRequest request) {
        String cookie = CookieUtils.getCookie(request, APPROVAL_TOKEN_NAME);
        log.info("modify cookie :"+JsonUtils.toJson(cookie));
        if (isEmpty(cookie)) {
            throw new SeniorPermissionRequiredException();
        }
        try {
            LoginToken loginToken = JsonUtils.fromJson(new String(Base64.getDecoder().decode(cookie)), LoginToken.class);
            log.info("modify request record,url:{},method:{},user:{}",
                    request.getRequestURL()+"?"+request.getQueryString(),request.getMethod(), JsonUtils.toJson(loginToken));

            if(!loginToken.getUserId().equals(id)){
                return -1;
            }
        } catch (Exception e) {
            log.error("modify cookie解析失败，默认未登录"+e);
            throw new SeniorPermissionRequiredException();
        }

        UserIdInfo userIdInfo = new UserIdInfo();
        userIdInfo.setId(id);
        if(!StringUtils.isEmpty(phone)) {
            userIdInfo.setCellphoneNumber(phone);
        }
        if(!StringUtils.isEmpty(desc)) {
            userIdInfo.setUserDesc(desc);
        }
        if(!StringUtils.isEmpty(password)){
            //MD5 摘要
            String s = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            userIdInfo.setPassword(s);
        }
        return userIdInfoMapper.updateByPrimaryKeySelective(userIdInfo);
    }

    @Override
    public boolean exist(String userName) {
        UserIdInfoExample example = new UserIdInfoExample();
        UserIdInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return userIdInfoMapper.countByExample(example) != 0;
    }

    @Override
    public UserInfoVo getInfo(long userId) {
        UserIdInfo userIdInfo = userIdInfoMapper.selectByPrimaryKey(userId);
        UserInfoVo userInfoVo = new UserInfoVo();
        if(userIdInfo == null){
            return null;
        }
        BeanUtils.copyProperties(userIdInfo,userInfoVo);
        userInfoVo.setUserType(UserTypeEnum.userType(userIdInfo.getUserType()));
        userInfoVo.setUserGrade(UserGradeEnum.userGrade(userIdInfo.getUserGrade()));

        return userInfoVo;
    }

    @Override
    public boolean isAdmin(Long userId) {
        log.info("233");
        try {
            UserIdInfo userIdInfo = userIdInfoMapper.selectByPrimaryKey(userId);
            log.info("isadmin " + JsonUtils.toJson(userIdInfo));
            if (userIdInfo == null) {
                return false;
            }
            return UserTypeEnum.isAdmin(userIdInfo.getUserType());
        }
        catch (Exception e){
            log.info("isAdmin error: "+e);
        }
        return false;
    }

    @Override
    public List<UserIdInfo> getUserList() {
        return userIdInfoMapper.selectByExample(new UserIdInfoExample());
    }
}
