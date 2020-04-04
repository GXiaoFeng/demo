package com.springcloud.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.demo.entity.Project;
import com.springcloud.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody Project product) {
        return projectService.add(product);
    }


    //当get方法出现异常时，则会调用hystrixGet方法处理
    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping(value = "/get/{id}")
    public Project get(@PathVariable("id") Long id) {

        Project project = projectService.get(id);
        // 如果project为空，就模拟一个异常
        if (project == null) {
            throw new RuntimeException("ID=" + id + "无效");
        }

        return project;
    }

    //当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
    public Project getFallback(@PathVariable("id") Long id) {

        return new Project(id, "ID=" + id + "无效--@HystrixCommand", "无有效数据库");
    }

    @GetMapping(value = "/list")
    public List<Project> list() {
        return projectService.list();
    }
}
