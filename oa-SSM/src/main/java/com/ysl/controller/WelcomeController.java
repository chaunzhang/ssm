package com.ysl.controller;

import com.ysl.pojo.User;
import com.ysl.service.UserService.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WelcomeController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserMapperService userService;

    @RequestMapping("/welcome")
    public void welcome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("loginname")){
                username = cookie.getValue();
            } else if (name.equals("loginpwd")){
                password = cookie.getValue();
            }
        }

        if (username != null && password != null){
            User user = new User(username, password);
            User user1 = userService.userLogin(user);
            if (user1 != null){
                request.getSession().setAttribute("USER_SESSION",user1);
                response.sendRedirect(request.getContextPath()+"/dept/allDept");
            }else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}
