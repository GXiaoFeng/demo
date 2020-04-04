package com.springcloud.demo.mapper;

import com.springcloud.demo.entity.Project;

import java.util.List;

//@Repository
public interface ProjectMapper {

    Project findById(Long pid);

    List<Project> findAll();

    boolean addProduct(Project product);
}
