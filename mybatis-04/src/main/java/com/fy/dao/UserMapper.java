package com.fy.dao;

import com.fy.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUser();

    //方法存在多个阐述，所有参数前面必须加@Param
    @Select("select * from user where id =#{id} and name=#{name}")
    User getUserById(@Param("id") int id,@Param("name") String name);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid") int id);

}
  