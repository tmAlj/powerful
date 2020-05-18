package com.wsd.powerful.admin.config;

import com.wsd.powerful.admin.service.UmsAdminService;
import com.wsd.powerful.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @description security安全配置
 * @author      tm
 * @createDate  2020-5-14 13:43
 * @updateDate  2020-5-14 13:43
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AdminSecurityConfig extends SecurityConfig {

    @Autowired
    private UmsAdminService adminService;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return username -> adminService.loadUserByUsername(username);
    }
}
