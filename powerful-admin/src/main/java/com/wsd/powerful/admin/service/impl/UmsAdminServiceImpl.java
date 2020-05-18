package com.wsd.powerful.admin.service.impl;

import com.wsd.powerful.admin.bo.AdminUserDetails;
import com.wsd.powerful.admin.dao.UmsAdminRoleRelationDao;
import com.wsd.powerful.admin.service.UmsAdminService;
import com.wsd.powerful.mbg.mapper.UmsAdminMapper;
import com.wsd.powerful.mbg.model.UmsAdmin;
import com.wsd.powerful.mbg.model.UmsAdminExample;
import com.wsd.powerful.mbg.model.UmsPermission;
import com.wsd.powerful.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 用户service
 * @author      tm
 * @createDate  2020-5-14 14:14
 * @updateDate  2020-5-14 14:14
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Autowired
    UmsAdminRoleRelationDao umsAdminRoleRelationDao;


    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsPermission> permissionList = getPermissionList(admin.getId());
            return new AdminUserDetails(admin,permissionList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            //updateLoginTimeByUsername(username);
            //insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.error("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = umsAdminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }
}
