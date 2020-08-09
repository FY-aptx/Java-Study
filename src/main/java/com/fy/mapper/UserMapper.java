package com.fy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fy.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的Mapper上面继承BaseMapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    //至此，所有的crud都编写完了



}
