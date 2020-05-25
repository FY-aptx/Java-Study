package com.fy.dao;

import com.fy.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    //原来这些操作都使用sqlSession来执行，现在使用SqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> selectuser() {
        User user=new User(5,"he","123123");


        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        userMapper.addUser(user);
        userMapper.deleteUser(5);

        return userMapper.selectuser();
    }

    public int addUser(User user) {
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);

        return  userMapper.addUser(user);
    }

    public int deleteUser(int id) {
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return userMapper.deleteUser(id);
    }
}
