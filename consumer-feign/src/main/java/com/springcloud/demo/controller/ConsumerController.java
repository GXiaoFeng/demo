package com.springcloud.demo.controller;

import com.springcloud.demo.entity.Project;
import com.springcloud.demo.service.ProjectClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者的控制曾
 * @Auther guanxiaofeng
 */
@RestController
@RequestMapping("/consumer/project")
public class ConsumerController {


    @Autowired
    ProjectClientService projectClientService;

    @RequestMapping(value = "/add")
    public boolean add(Project project) {
        return projectClientService.add(project);
    }

    @RequestMapping(value = "/get/{id}")
    public Project get(@PathVariable("id") Long id) {
        return projectClientService.get(id);
    }

    @RequestMapping(value = "/list")
    public List<Project> list(){
            return projectClientService.list();
    }
}
