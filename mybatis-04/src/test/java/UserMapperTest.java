import com.fy.dao.UserMapper;
import com.fy.pojo.User;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUser(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUser();

        for (User user : users) {
            System.out.println(user );

        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1, "FY");

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(6,"haha","123456"));

        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(6,"hehe","123456"));

        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);

        //sqlSession.commit();
        sqlSession.close();
    }
}
