package com.fy.config;

import com.fy.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//这个也会spring容器托管，注册到容器中，因为他本来就是一个@component
//@Configuration代表这是一个配置类，相当于之前看的beans.xml

@ComponentScan("com.fy.pojo")
@Import(Myconfig2.class)
public class MyConfig {

    //@Bean
    //单用此注解也可得到bean
    public User getUser(){
        return new User();
    }
}
