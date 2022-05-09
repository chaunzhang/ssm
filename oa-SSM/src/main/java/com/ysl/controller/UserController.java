package com.ysl.controller;

import com.ysl.pojo.User;
import com.ysl.service.UserService.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserMapperService userService;


    //登录验证
    @RequestMapping("/userLogin")
    public String userLogin(User user, HttpServletRequest request,HttpServletResponse response ,Model model){
        User user1 = userService.userLogin(user);
        if (user1 != null){
            request.getSession().setAttribute("USER_SESSION",user1);

            //用户登录成功，并且选择十天内免登录
            String rem = request.getParameter("rem");
            if ("1".equals(rem)){
                Cookie cookie1 = new Cookie("loginname",user1.getUsername());
                Cookie cookie2 = new Cookie("loginpwd", user1.getPassword());

                //cookie的有效期
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);

                //设置cookie的路径
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());

                //将cookie响应到浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);

                //model.addAttribute("username",user.getUsername());
                //model.addAttribute("password",user.getPassword());
                //model.addAttribute("check",true);

            }

            return "redirect:/dept/allDept";
        }
        else {
            return "error";
        }
    }

    //登录注销
    @RequestMapping("/userLogout")
    public void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("userLogout Execute");
        request.getSession().removeAttribute("USER_SESSION");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    //跳转到用户注册页面
    @RequestMapping("/toUserRegisterPage")
    public String toUserRegisterPage(){
        return "UserRegisterPage";
    }

    //用户注册
    @RequestMapping("/UesrRegister")
    public void UserRegister(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
        boolean b = userService.userRegister(user);
        if (b == true){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            response.sendRedirect(request.getContextPath()+"/LogUpError.jsp");
        }
    }

}
