package com.fy.dao;

import com.fy.pojo.User;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger=Logger.getLogger(UserMapperTest.class);




    @Test
    public void getUserById(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        User user=mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }


    //日志
    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }


    //分页
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList=mapper.getUserByLimit(map);
        for (User user: userList) {
            System.out.println(user);

        }

        sqlSession.close();
    }

    //分页2
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();

        //RowBounds
        RowBounds rowBounds = new RowBounds(1, 2);

        List<User> userList = sqlSession.selectList("com.fy.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user: userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
