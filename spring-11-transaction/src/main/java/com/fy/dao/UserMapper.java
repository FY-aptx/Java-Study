package com.fy.dao;

import com.fy.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectuser();

    //添加一个用户
    public int addUser(User user);

    //删除一个用户
    public int deleteUser(int id);

}
