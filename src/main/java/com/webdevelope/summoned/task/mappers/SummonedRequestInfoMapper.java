package com.webdevelope.summoned.task.mappers;

import com.webdevelope.summoned.task.model.SummonedRequestInfo;
import com.webdevelope.summoned.task.model.SummonedRequestInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummonedRequestInfoMapper {
    long countByExample(SummonedRequestInfoExample example);

    int deleteByExample(SummonedRequestInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SummonedRequestInfo record);

    int insertSelective(SummonedRequestInfo record);

    List<SummonedRequestInfo> selectByExample(SummonedRequestInfoExample example);

    SummonedRequestInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SummonedRequestInfo record, @Param("example") SummonedRequestInfoExample example);

    int updateByExample(@Param("record") SummonedRequestInfo record, @Param("example") SummonedRequestInfoExample example);

    int updateByPrimaryKeySelective(SummonedRequestInfo record);

    int updateByPrimaryKey(SummonedRequestInfo record);
}