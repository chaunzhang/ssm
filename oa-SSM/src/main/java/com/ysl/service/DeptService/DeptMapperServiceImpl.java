package com.ysl.service.DeptService;

import com.ysl.dao.DeptDao.DeptMapper;
import com.ysl.pojo.Dept;

import java.util.List;

public class DeptMapperServiceImpl implements DeptMapperService {
    private DeptMapper deptMapper;

    public void setDeptMapper(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int delDept(int id) {
        return deptMapper.delDept(id);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }

    @Override
    public Dept queryDeptById(int id) {
        return deptMapper.queryDeptById(id);
    }

    @Override
    public List<Dept> queryByName(String name) {
        return deptMapper.queryByName(name);
    }

}
