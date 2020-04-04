package com.springcloud.demo.controller;

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

    @GetMapping(value = "/get/{id}")
    public Project get(@PathVariable("id") Long id) {
        return projectService.get(id);
    }

    @GetMapping(value = "/list")
    public List<Project> list() {
        return projectService.list();
    }
}
