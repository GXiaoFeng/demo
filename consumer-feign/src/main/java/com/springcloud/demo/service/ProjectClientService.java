package com.springcloud.demo.service;

import com.springcloud.demo.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//指定调用的服务 PROVIDER-HYSTRIX
@FeignClient(value = "PROVIDER")
@RequestMapping("/project")
public interface ProjectClientService {

    @PostMapping(value = "/add")
    boolean add(@RequestBody Project project);

    @GetMapping(value = "/list")
    List<Project> list();

    @GetMapping(value = "/get/{id}")
    Project get(@PathVariable("id") Long id);

}
