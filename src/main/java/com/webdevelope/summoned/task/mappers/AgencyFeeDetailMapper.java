package com.webdevelope.summoned.task.mappers;

import com.webdevelope.summoned.task.model.AgencyFeeDetail;
import com.webdevelope.summoned.task.model.AgencyFeeDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyFeeDetailMapper {
    long countByExample(AgencyFeeDetailExample example);

    int deleteByExample(AgencyFeeDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AgencyFeeDetail record);

    int insertSelective(AgencyFeeDetail record);

    List<AgencyFeeDetail> selectByExample(AgencyFeeDetailExample example);

    AgencyFeeDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AgencyFeeDetail record, @Param("example") AgencyFeeDetailExample example);

    int updateByExample(@Param("record") AgencyFeeDetail record, @Param("example") AgencyFeeDetailExample example);

    int updateByPrimaryKeySelective(AgencyFeeDetail record);

    int updateByPrimaryKey(AgencyFeeDetail record);
}