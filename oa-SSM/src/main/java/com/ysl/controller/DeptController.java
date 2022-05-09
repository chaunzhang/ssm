package com.ysl.controller;


import com.ysl.pojo.Dept;
import com.ysl.service.DeptService.DeptMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    @Qualifier("DeptServiceImpl")
    private DeptMapperService deptservice;

    //所有部门信息
    @RequestMapping("/allDept")
    public String allDept(Model model){
        List<Dept> depts = deptservice.queryAll();
        model.addAttribute("list",depts);
        return "allDept";
    }

    //跳转到增加部门页面
    @RequestMapping("/toAddPage")
    public String toAddPage(){
        return "addDept";
    }

    //添加部门信息
    @RequestMapping("/addDept")
    public String addDept(Dept dept){
        deptservice.addDept(dept);
        System.out.println(dept);
        return "redirect:/dept/allDept";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(@RequestParam("deptno") int deptno, Model model){
        Dept dept = deptservice.queryDeptById(deptno);
        model.addAttribute("dept",dept);
        return "updateDept";
    }

    //修改部门信息
    @RequestMapping("/updateDept")
    public String updateDept(Dept dept){
        deptservice.updateDept(dept);
        return "redirect:/dept/allDept";
    }

    //删除部门
    @RequestMapping("/delDept")
    public String delDept(@RequestParam("deptno") int id){
        deptservice.delDept(id);
        return "redirect:/dept/allDept";
    }

    //根据名称查询部门
    @RequestMapping("/queryByName")
    public String queryByName(@RequestParam("queryDeptName") String dname ,Model model){
        List<Dept> depts = deptservice.queryByName(dname);
        model.addAttribute("list",depts);
        return "allDept";
    }
}
