package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //表示是服务注册中心
public class RegistrationCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationCenterApplication.class,args);
    }
}
