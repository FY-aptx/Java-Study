package com.fy;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fy.mapper.UserMapper;
import com.fy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        //参数是一个Wrapper，条件构造器，不用的话先用null
        //查询全部用户
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        /*for (User user : userList) {
            System.out.println(user);
        }*/
    }

    //测试插入
    @Test
    public void testInsert(){
        User user=new User();
        user.setName("小明");
        user.setAge(1);
        user.setEmail("123456@qq.com");

        //会帮我们自动设置id
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);

    }

    //测试更新
    @Test
    public void testupdate(){
        User user=new User();
        user.setId(1272549679978426372L);
        user.setName("小明2");
        user.setAge(5);

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(1L);
        user.setName("BOb");
        user.setEmail("testOptimisticLocker@123.com");
        userMapper.updateById(user);
    }

    //测试乐观锁失败
    @Test
    public void testOptimisticLocker2(){
        User user = userMapper.selectById(1L);
        user.setName("BOb");
        user.setEmail("testOptimisticLocker@123.com");
        //没提交

        //模拟另一个线程执行了插入操作
        User user2=userMapper.selectById(1L);
        user2.setName("BOb22");
        userMapper.updateById(user2);

        userMapper.updateById(user);
    }

    //测试查询
    @Test
    public void testSelectById(){
        User user=userMapper.selectById(1L);
        System.out.println(user);
    }

    //测试批量查询
    @Test
    public void testSelectByBatchId(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        userList.forEach(System.out::println);
    }

    //测试条件查询 map
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("name","FY");

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

    //测试分页查询
    @Test
    public void testpage(){
        /*
        *  参数一：当前页
        * 参数二：页面大小
        * */

        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
    }

    //测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1L);
    }

    //测试通过id批量删除
    @Test
    public void testDeleteBatchID(){
        userMapper.deleteBatchIds(Arrays.asList(1272549679978426369L,1272549679978426370L));

    }

    //测试通过Map删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","小明");
        userMapper.deleteByMap(map);

    }




}
