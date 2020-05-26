package com.fy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();

        //放行：判断什么情况下登录
        if(session.getAttribute("useLoginInfo")!=null){
            return true;
        }

        //放行，处于登录页面
        if(request.getRequestURI().contains("login")){
            return true;

        }

        //放行，处于登录页面
        if(request.getRequestURI().contains("goLogin")){
            return true;

        }

        //判断什么情况下没有登录

        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);


        return false;
    }
}
