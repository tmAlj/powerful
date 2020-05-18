package com.wsd.powerful.mbg.mapper;

import com.wsd.powerful.mbg.model.UmsAdminOrgn;
import com.wsd.powerful.mbg.model.UmsAdminOrgnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminOrgnMapper {
    long countByExample(UmsAdminOrgnExample example);

    int deleteByExample(UmsAdminOrgnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminOrgn record);

    int insertSelective(UmsAdminOrgn record);

    List<UmsAdminOrgn> selectByExample(UmsAdminOrgnExample example);

    UmsAdminOrgn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsAdminOrgn record, @Param("example") UmsAdminOrgnExample example);

    int updateByExample(@Param("record") UmsAdminOrgn record, @Param("example") UmsAdminOrgnExample example);

    int updateByPrimaryKeySelective(UmsAdminOrgn record);

    int updateByPrimaryKey(UmsAdminOrgn record);
}