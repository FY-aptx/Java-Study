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
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        userMapper.selectuser();


        return userMapper.selectuser();
    }
}
