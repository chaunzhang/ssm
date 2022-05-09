package com.ysl.config;

import com.ysl.pojo.User;
import com.ysl.service.UserService.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserMapperService userService;

    //前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            //Cookie[] cookies = request.getCookies();
            //String username = null;
            //String password = null;
            //for (Cookie cookie : cookies) {
            //    String name = cookie.getName();
            //    if (name.equals("loginname")){
            //        username = cookie.getValue();
            //    } else if (name.equals("loginpwd")){
            //        password = cookie.getValue();
            //    }
            //}
            //
            //if (username != null && password != null){
            //    User user = new User(username, password);
            //    User user1 = userService.userLogin(user);
            //    if (user1 != null){
            //        System.out.println("1");
            //        request.getSession().setAttribute("USER_SESSION",user1);
            //        //response.sendRedirect(request.getContextPath()+"/dept/allDept");
            //        //request.getRequestDispatcher(request.getContextPath()+"/dept/allDept").forward(request,response);
            //        return true;
            //    }else {
            //        System.out.println("2");
            //        //response.sendRedirect(request.getContextPath()+"/index.jsp");
            //        request.getRequestDispatcher(request.getContextPath()+"/index,jsp").forward(request,response);
            //        return false;
            //    }
            //} else {
            //    System.out.println("3");
            //    //response.sendRedirect(request.getContextPath()+"/index.jsp");
            //    request.getRequestDispatcher(request.getContextPath()+"/index,jsp").forward(request,response);
            //    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            //
            //
            //    return false;
            //}
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.getRequestDispatcher("/index.jsp");
        }
        return true;
    }

    //后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
