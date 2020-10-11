package com.webdevelope.summoned.task.mappers;

import com.webdevelope.summoned.task.model.SummonedResponseInfo;
import com.webdevelope.summoned.task.model.SummonedResponseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummonedResponseInfoMapper {
    long countByExample(SummonedResponseInfoExample example);

    int deleteByExample(SummonedResponseInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SummonedResponseInfo record);

    int insertSelective(SummonedResponseInfo record);

    List<SummonedResponseInfo> selectByExample(SummonedResponseInfoExample example);

    SummonedResponseInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SummonedResponseInfo record, @Param("example") SummonedResponseInfoExample example);

    int updateByExample(@Param("record") SummonedResponseInfo record, @Param("example") SummonedResponseInfoExample example);

    int updateByPrimaryKeySelective(SummonedResponseInfo record);

    int updateByPrimaryKey(SummonedResponseInfo record);
}