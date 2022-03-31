package top.xxgo.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.auth.pojo.LoginDto;
import top.xxgo.auth.service.AuthBizService;
import top.xxgo.project.enetiy.UserInfo;
import top.xxgo.project.version.BaseController;

/**
 * @author xxg
 * @date 2022/3/14 10:03
 */
@RestController
public class TokenController  extends BaseController {


    @Autowired
    private AuthBizService authBizService;

    @PostMapping("login")
    public  void login(@RequestBody LoginDto loginDto){

       UserInfo userInfo= authBizService.login(loginDto);


    }



}
