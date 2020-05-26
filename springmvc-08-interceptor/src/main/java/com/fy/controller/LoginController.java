package com.fy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){

        return "login";
    }



    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){

        session.setAttribute("useLoginInfo",username);
        model.addAttribute("username",username);
        return "main";

    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session, String username, String password, Model model){

        session.removeAttribute("useLoginInfo");

        return "main";

    }


}
