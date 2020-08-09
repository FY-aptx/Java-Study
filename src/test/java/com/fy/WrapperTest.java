package com.fy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fy.mapper.UserMapper;
import com.fy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        /*
        * 查询name不为空，邮箱不为空，年龄大于20岁的用户
        * */
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",20);

        userMapper.selectList(wrapper).forEach(System.out::println);

    }

    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name","B")
                .likeRight("email","t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","Select id from user where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);

    }

    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);

    }

}
