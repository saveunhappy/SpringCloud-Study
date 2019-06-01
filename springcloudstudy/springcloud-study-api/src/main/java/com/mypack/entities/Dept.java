package com.mypack.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    /**
     *  部门编码 主键
     */
    private Long deptNo;
    /**
     * 部门名称
     */
    private String deptName;

    private String dbSource;//来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息可以存储到不同数据库

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDbSource("db01").setDeptName("hehe").setDeptNo(1L);
        System.out.println(dept);
    }
}
