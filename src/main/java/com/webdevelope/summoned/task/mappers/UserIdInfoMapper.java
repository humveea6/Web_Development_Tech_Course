package com.webdevelope.summoned.task.mappers;

import com.webdevelope.summoned.task.model.UserIdInfo;
import com.webdevelope.summoned.task.model.UserIdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIdInfoMapper {
    long countByExample(UserIdInfoExample example);

    int deleteByExample(UserIdInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserIdInfo record);

    int insertSelective(UserIdInfo record);

    List<UserIdInfo> selectByExample(UserIdInfoExample example);

    UserIdInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserIdInfo record, @Param("example") UserIdInfoExample example);

    int updateByExample(@Param("record") UserIdInfo record, @Param("example") UserIdInfoExample example);

    int updateByPrimaryKeySelective(UserIdInfo record);

    int updateByPrimaryKey(UserIdInfo record);
}