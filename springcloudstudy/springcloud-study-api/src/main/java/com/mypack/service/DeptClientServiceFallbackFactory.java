package com.mypack.service;

import com.mypack.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept deptEntity) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
                return new Dept().setDeptNo(id).setDeptName("该ID"+id+"没有对应的信息provider")
                        .setDbSource("no this database in MYSQL");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
