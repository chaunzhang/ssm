package com.ysl.service.DeptService;

import com.ysl.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapperService {
    //增加一个部门
    int addDept(Dept dept);

    //删除一个部门
    int delDept(int id);

    //修改部门信息
    int updateDept(Dept dept);

    //查询所有部门
    List<Dept> queryAll();

    //根据id查询部门信息
    Dept queryDeptById(int id);

    //根据部门名字模糊查询
    List<Dept> queryByName( String name);
}
