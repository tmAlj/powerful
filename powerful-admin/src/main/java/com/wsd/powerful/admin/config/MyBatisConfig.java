package com.wsd.powerful.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description MyBatis配置类
 * @author      tm
 * @createDate  2020-5-14 13:46
 * @updateDate  2020-5-14 13:46
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Configuration
@EnableTransactionManagement
@MapperScan({"com.wsd.powerful.mbg.mapper","com.wsd.powerful.admin.dao"})
public class MyBatisConfig {
}
