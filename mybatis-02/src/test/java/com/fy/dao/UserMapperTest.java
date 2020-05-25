package com.fy.dao;

import com.fy.pojo.User;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {


    @Test
    public  void test(){
        //第一步：获得sqlsession对象
        SqlSession sqlSession= MybatisUtils.getsqlSession();

        try{

            //执行sql:方式1-->getMapper
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            //mapper.getUserList();
            List<User> userList=mapper.getUserList();

            //方式2-->不推荐
            //List<User> userList1=sqlSession.selectList("com.fy.dao.UserMapper.getUserList");

            for (User user: userList) {
                System.out.println(user);

            }


        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭sqlsession
            sqlSession.close();

        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        User user=mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }


    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"FYYI","654321"));

        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void updateUser(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"FYTest","123123"));


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);


        sqlSession.commit();
        sqlSession.close();
    }
}
