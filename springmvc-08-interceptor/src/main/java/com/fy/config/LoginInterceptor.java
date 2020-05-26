package com.fy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();

        //���У��ж�ʲô����µ�¼
        if(session.getAttribute("useLoginInfo")!=null){
            return true;
        }

        //���У����ڵ�¼ҳ��
        if(request.getRequestURI().contains("login")){
            return true;

        }

        //���У����ڵ�¼ҳ��
        if(request.getRequestURI().contains("goLogin")){
            return true;

        }

        //�ж�ʲô�����û�е�¼

        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);


        return false;
    }
}
