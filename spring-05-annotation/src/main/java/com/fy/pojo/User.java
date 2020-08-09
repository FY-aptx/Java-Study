package com.fy.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
//Component组件，等价于<bean id="user" class="com.fy.pojo.User"/>
public class User {
    @Value("FY")
    //value,相当于<property name="name",value="FY"/>
    public String name;
}
