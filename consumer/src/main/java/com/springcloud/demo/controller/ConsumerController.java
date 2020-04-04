package com.springcloud.demo.controller;

import com.springcloud.demo.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者的控制曾
 * @Auther guanxiaofeng
 */
@RestController
@RequestMapping("/consumer/project")
public class ConsumerController {

    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    // 修改为Eureka注册中心的地址
    private static final String REST_URL_PREFIX = "http://provider";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public boolean add(Project project) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/project/add", project, Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public Project get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/project/get/" + id, Project.class);
    }

    @RequestMapping(value = "/list")
    public List<Project> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/project/list", List.class);
    }
}
