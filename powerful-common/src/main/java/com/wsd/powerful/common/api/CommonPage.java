package com.wsd.powerful.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description 分页数据封装类
 * @author      tm
 * @createDate  2020-5-14 11:22
 * @updateDate  2020-5-14 11:22
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     *@description 将PageHelper分页后的list转为分页信息
     *@params  [list]
     *@return  com.wsd.powerful.common.api.CommonPage<T>
     *@author  tm
     *@createDate  2020-5-14 11:22
     *@updateRemark
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     *@description 将SpringData分页后的list转为分页信息
     *@params  [pageInfo]
     *@return  com.wsd.powerful.common.api.CommonPage<T>
     *@author  tm
     *@createDate  2020-5-14 11:23
     *@updateRemark
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
