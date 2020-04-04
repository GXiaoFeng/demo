package com.springcloud.demo.service;

import com.springcloud.demo.entity.Project;

import java.util.List;

public interface ProjectService {
    boolean add(Project project);

    Project get(Long id);

    List<Project> list();
}
