package com.wsd.powerful.mbg.mapper;

import com.wsd.powerful.mbg.model.UmsPost;
import com.wsd.powerful.mbg.model.UmsPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsPostMapper {
    long countByExample(UmsPostExample example);

    int deleteByExample(UmsPostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsPost record);

    int insertSelective(UmsPost record);

    List<UmsPost> selectByExample(UmsPostExample example);

    UmsPost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsPost record, @Param("example") UmsPostExample example);

    int updateByExample(@Param("record") UmsPost record, @Param("example") UmsPostExample example);

    int updateByPrimaryKeySelective(UmsPost record);

    int updateByPrimaryKey(UmsPost record);
}