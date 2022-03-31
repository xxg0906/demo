package top.xxgo.auth.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xxg
 * @date 2022/3/14 10:30
 */
@Data
public class LoginDto {


    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("登录密码")
    private  String password;

    @ApiModelProperty("验证码")
    private  String captcha;





}
