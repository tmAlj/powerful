package com.wsd.powerful.admin.service;

import com.wsd.powerful.mbg.model.UmsAdmin;
import com.wsd.powerful.mbg.model.UmsPermission;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @description 用户service
 * @author      tm
 * @createDate  2020-5-14 14:00
 * @updateDate  2020-5-14 14:00
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public interface UmsAdminService {

    /**
     * 根据用户名获取用户
     * @param username  用户名
     * @return 用户
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return springSecurity实体
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取用户所有权限
     * @param adminId 用户id
     * @return 用户权限
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功后token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);
}
