package com.fy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fy.pojo.User;
import com.fy.utils.JsonUtils;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RestController 可以不用@ResponseBody也会直接返回一个字符串
@Controller
public class UserController {

    //解决乱码，方式一：
    //@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")

    //方式二：在servletmv-servlet中添加配置
    @RequestMapping("/j1")
    @ResponseBody//用这个注解，就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //json
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("FYYI",3,"男");
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/j2")
    @ResponseBody//用这个注解，就不会走视图解析器，会直接返回一个字符串
    //将Json封装成工具类
    public String json2() {

        List<User> userList=new ArrayList<User>();

        //创建一个对象
        User user1 = new User("FY1",3,"男");
        User user2 = new User("FY2",3,"男");
        User user3 = new User("FY3",3,"男");
        User user4 = new User("FY4",3,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        return JsonUtils.getJson(userList);
    }

    @RequestMapping("/j3")
    @ResponseBody//用这个注解，就不会走视图解析器，会直接返回一个字符串
    public String json3() throws JsonProcessingException {
        //json
        ObjectMapper mapper = new ObjectMapper();
        Date date=new Date();

        //定义日期格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String format = sdf.format(date);
        return mapper.writeValueAsString(format);
    }

    @RequestMapping("/j4")
    @ResponseBody//用这个注解，就不会走视图解析器，会直接返回一个字符串
    public String json4() {
        Date date=new Date();

        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j5")
    //使用fastjson
    @ResponseBody//用这个注解，就不会走视图解析器，会直接返回一个字符串
    public String json5() {
        List<User> userList=new ArrayList<User>();

        //创建一个对象
        User user1 = new User("FY1",3,"男");
        User user2 = new User("FY2",3,"男");
        User user3 = new User("FY3",3,"男");
        User user4 = new User("FY4",3,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "Hello";
    }
}
