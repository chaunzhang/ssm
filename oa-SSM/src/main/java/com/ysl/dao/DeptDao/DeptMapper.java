package com.ysl.dao.DeptDao;

import com.ysl.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    //增加一个部门
    int addDept(Dept dept);

    //删除一个部门
    int delDept(@Param("deptno") int id);

    //修改部门信息
    int updateDept(Dept dept);

    //查询所有部门
    List<Dept> queryAll();

    //根据id查询部门信息
    Dept queryDeptById(@Param("deptno") int id);

    //根据部门名字模糊查询
    List<Dept> queryByName(@Param("dname") String name);

}
