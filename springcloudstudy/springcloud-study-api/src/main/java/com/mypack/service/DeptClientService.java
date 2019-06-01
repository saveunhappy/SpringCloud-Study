package com.mypack.service;

import com.mypack.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "STUDY-SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping("/dept/add")
    public boolean add( Dept deptEntity);

    @GetMapping("/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> findAll();
}
