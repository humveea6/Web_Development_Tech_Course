package com.webdevelope.summoned.task.service.Impl;

import com.webdevelope.summoned.task.enums.UserGradeEnum;
import com.webdevelope.summoned.task.enums.UserTypeEnum;
import com.webdevelope.summoned.task.mappers.UserIdInfoMapper;
import com.webdevelope.summoned.task.model.UserIdInfo;
import com.webdevelope.summoned.task.model.UserIdInfoExample;
import com.webdevelope.summoned.task.service.UserInfoService;
import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.vo.ResponseVo;
import com.webdevelope.summoned.task.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author LingChen
 * Created on 2020-10-14
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserIdInfoMapper userIdInfoMapper;

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
        if(userList == null){
            //return error
            return ResponseVo.USER_NOT_EXIST_OR_PASSWORD_ERROR();
        }
        UserIdInfo user = userList.get(0);
        if(!user.getPassword().equalsIgnoreCase(DigestUtils.
                md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            //password error
            return ResponseVo.USER_NOT_EXIST_OR_PASSWORD_ERROR();
        }
        user.setPassword("");

        return ResponseVo.success(user);
    }

    @Override
    public int modify(long id, String password, String phone,String desc) {
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
}
