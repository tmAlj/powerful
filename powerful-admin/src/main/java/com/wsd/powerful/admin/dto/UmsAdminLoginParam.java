package com.wsd.powerful.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @description 登录参数
 * @author      tm
 * @createDate  2020-5-14 16:36
 * @updateDate  2020-5-14 16:36
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Getter
@Setter
public class UmsAdminLoginParam {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
}
