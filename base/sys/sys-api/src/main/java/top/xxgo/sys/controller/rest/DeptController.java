package top.xxgo.sys.controller.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.project.version.BaseController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@RestController
@RequestMapping("dept")
@RefreshScope
public class DeptController extends BaseController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Value("${test}")
    private String test;

    @Autowired
    private Environment env;


    @GetMapping("test")
    public String test(){
        String[] activeProfiles = env.getActiveProfiles();
        String[] defaultProfiles = env.getDefaultProfiles();
        System.out.println(defaultProfiles);
        System.out.println(test);
        return env.getProperty("test");
//        return this.test;
    }
}

