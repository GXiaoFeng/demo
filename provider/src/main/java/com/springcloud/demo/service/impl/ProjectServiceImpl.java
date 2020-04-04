package com.springcloud.demo.service.impl;

import com.springcloud.demo.entity.Project;
import com.springcloud.demo.mapper.ProjectMapper;
import com.springcloud.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public boolean add(Project product) {
        return  projectMapper.addProduct(product);
    }

    @Override
    public Project get(Long id) {
        return projectMapper.findById(id);
    }

    @Override
    public List<Project> list() {
        return projectMapper.findAll();
    }
}
