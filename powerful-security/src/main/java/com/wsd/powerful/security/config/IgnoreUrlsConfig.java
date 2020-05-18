package com.wsd.powerful.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 用于配置不需要保护的资源路径
 * @author      tm
 * @createDate  2020-5-14 12:19
 * @updateDate  2020-5-14 12:19
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

}
