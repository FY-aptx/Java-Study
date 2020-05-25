import com.fy.dao.UserMapper;
import com.fy.dao.UserMapperImpl;
import com.fy.pojo.User;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void selectuser(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectuser();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void selectuser2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);

        List<User> userList = userMapper.selectuser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
