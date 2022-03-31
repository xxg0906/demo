package com.example.sys.rest;

import com.example.sys.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xxg
 * @date 2022/3/14 14:31
 */
@FeignClient(value = "sys")
public interface SysUserInfoFeign {


    /**
     * 获取用户信息
     * @param userInfo 用户信息
     * @return 用户信息
     */
    @RequestMapping("getUserInfo")
    UserInfo  getUserInfo(@RequestBody UserInfo userInfo);


    /**
     * 获取用户信息
     * @param userInfo 用户信息
     * @return 用户信息
     */
    @RequestMapping("getUserInfo")
    UserInfo  check(@RequestBody UserInfo userInfo);

}
