package com.wsd.powerful.admin.dao;

import com.wsd.powerful.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @description 用户与角色Dao
 * @author      tm
 * @createDate  2020-5-14 14:52
 * @updateDate  2020-5-14 14:52
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
