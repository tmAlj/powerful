package com.wsd.powerful.mbg.mapper;

import com.wsd.powerful.mbg.model.UmsOrgn;
import com.wsd.powerful.mbg.model.UmsOrgnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsOrgnMapper {
    long countByExample(UmsOrgnExample example);

    int deleteByExample(UmsOrgnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsOrgn record);

    int insertSelective(UmsOrgn record);

    List<UmsOrgn> selectByExample(UmsOrgnExample example);

    UmsOrgn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsOrgn record, @Param("example") UmsOrgnExample example);

    int updateByExample(@Param("record") UmsOrgn record, @Param("example") UmsOrgnExample example);

    int updateByPrimaryKeySelective(UmsOrgn record);

    int updateByPrimaryKey(UmsOrgn record);
}