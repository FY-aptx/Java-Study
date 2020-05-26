package com.fy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.DELETE)
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","结果1为"+res);
        return "test";
    }

    @PostMapping(value = "/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","结果2为"+res);
        return "test";
    }

    @GetMapping(value = "/add/{a}/{b}")
    public String test3(@PathVariable int a, @PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","结果3为"+res);
        return "test";
    }
}
