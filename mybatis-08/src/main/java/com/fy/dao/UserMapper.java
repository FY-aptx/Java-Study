package com.fy.dao;

import com.fy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //根据ID查询用户
    User queryUsersById(@Param("id") int id);

    //修改用户
    int updateUser(User user);


}
