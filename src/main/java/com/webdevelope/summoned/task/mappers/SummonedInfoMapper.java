package com.webdevelope.summoned.task.mappers;

import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.model.SummonedInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummonedInfoMapper {
    long countByExample(SummonedInfoExample example);

    int deleteByExample(SummonedInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SummonedInfo record);

    int insertSelective(SummonedInfo record);

    List<SummonedInfo> selectByExample(SummonedInfoExample example);

    SummonedInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SummonedInfo record, @Param("example") SummonedInfoExample example);

    int updateByExample(@Param("record") SummonedInfo record, @Param("example") SummonedInfoExample example);

    int updateByPrimaryKeySelective(SummonedInfo record);

    int updateByPrimaryKey(SummonedInfo record);
}