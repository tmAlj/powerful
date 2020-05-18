package com.wsd.powerful.security.component;

import cn.hutool.json.JSONUtil;
import com.wsd.powerful.common.api.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 自定义返回结果：没有权限访问时
 * @author      tm
 * @createDate  2020-5-14 13:18
 * @updateDate  2020-5-14 13:18
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public class RestfulAccessDeniedHandler implements AccessDeniedHandler{
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
