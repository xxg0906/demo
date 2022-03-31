package com.example.sys.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xxg
 * @date 2022/3/14 15:17
 */
@Data
public class UserInfo {



    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("登录密码")
    private  String password;

    @ApiModelProperty("验证码")
    private  String captcha;


}
