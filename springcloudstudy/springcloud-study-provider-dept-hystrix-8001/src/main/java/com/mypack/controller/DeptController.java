package com.mypack.controller;

import com.mypack.entities.Dept;
import com.mypack.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    //@RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
        return service.addDept(dept);
    }

    //@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @GetMapping("/dept/get/{id}")
   // @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = service.findById(id);
        if(null==dept){
            throw new RuntimeException("该ID"+id+"没有对应的信息");
        }
        return dept;
    }
   // @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    @GetMapping("/dept/list")
    public List<Dept> list(){
        return service.findAll();
    }

    public Dept processHystrix_Get(@PathVariable("id")Long id){
        return new Dept().setDeptNo(id).setDeptName("该ID"+id+"没有对应的信息，null--@HystrixCommand")
                .setDbSource("no this database in MYSQL");
    }

}
