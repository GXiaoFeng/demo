package com.springcloud.demo.mapper;

import com.springcloud.demo.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface ProjectMapper {

    Project findById(Long pid);

    List<Project> findAll();

    boolean addProduct(Project product);
}
