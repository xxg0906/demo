package top.xxgo.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("top.xxgo.*.mapper")
@EnableDiscoveryClient
public class SysApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApiApplication.class, args);
    }

}
