package com.wsd.powerful.security.component;

import cn.hutool.json.JSONUtil;
import com.wsd.powerful.common.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 定义返回结果：未登录或登录过期
 * @author      tm
 * @createDate  2020-5-14 13:18
 * @updateDate  2020-5-14 13:18
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
