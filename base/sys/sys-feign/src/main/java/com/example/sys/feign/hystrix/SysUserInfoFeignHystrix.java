package com.example.sys.feign.hystrix;

import com.example.sys.pojo.UserInfo;
import com.example.sys.feign.SysUserInfoFeign;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author xxg
 * @date 2022/3/14 15:48
 */
@Component
public class SysUserInfoFeignHystrix implements FallbackFactory<SysUserInfoFeign> {

    public SysUserInfoFeign create(Throwable cause) {
        return new SysUserInfoFeign() {
            public UserInfo getUserInfo(UserInfo userInfo) {
                return null;
            }

            public UserInfo check(UserInfo userInfo) {
                return null;
            }
        };

    }
}
