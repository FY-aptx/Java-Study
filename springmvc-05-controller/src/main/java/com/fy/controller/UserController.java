package com.fy.controller;


import com.fy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/t1")
    public String test1(@RequestParam("usename") String name, Model model){
        //1、接收前端参数
        System.out.println("接收到前段的参数为："+name);

        //2、将返回结果传递给前端，model
        model.addAttribute("msg",name);

        //3、视图跳转
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(User user){
        /**
         * 1、接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
         * 2、假设传递的是一个对象User，匹配User对象中的字段名；如果名字一致则OK，否则，匹配不到
         */

        System.out.println(user);
        return "test";
    }



}
