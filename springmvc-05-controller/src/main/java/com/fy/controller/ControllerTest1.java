package com.fy.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//只要实现了Controller接口的类，说明这是一个控制器了
public class ControllerTest1 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","ControllerTest1");
        mv.setViewName("test");


        return mv;
    }
}
