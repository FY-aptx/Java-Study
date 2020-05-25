import com.fy.dao.UserMapper;
import com.fy.pojo.User;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void queryUsersById(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = userMapper.queryUsersById(1);
        System.out.println(user1);
        // 关闭以及缓存
        sqlSession.clearCache();//一级缓存默认是开启的，只在一次SqlSession中有效

        System.out.println("================================");

        User user2 = userMapper.queryUsersById(1);
        System.out.println(user2);

        System.out.println(user1==user2);

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = userMapper.queryUsersById(1);
        System.out.println(user1);

        userMapper.updateUser(new User(2,"hehe","123456"));

        // 关闭以及缓存
        //sqlSession.clearCache();//一级缓存默认是开启的，只在一次SqlSession中有效


        System.out.println("================================");

        User user2 = userMapper.queryUsersById(1);
        System.out.println(user2);

        System.out.println(user1==user2);

        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession1= MybatisUtils.getsqlSession();
        SqlSession sqlSession2= MybatisUtils.getsqlSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);


        User user1 = userMapper1.queryUsersById(1);
        System.out.println(user1);
        sqlSession1.close();

        System.out.println("================================");

        User user2 = userMapper2.queryUsersById(1);
        System.out.println(user2);

        System.out.println(user1==user2);
        sqlSession2.close();
    }
}
