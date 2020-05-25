import com.fy.dao.UserOracleImpl;
import com.fy.service.UserService;
import com.fy.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
       /* //用户实际调用的是业务层，dao层不需要接触
        UserServiceImpl userService = new UserServiceImpl();

        ((UserServiceImpl)userService).setUserDao(new UserOracleImpl());
        userService.getUser();*/
        //获取ApplicationContext
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //容器在手，天下我有，需要什么，get什么
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");

        userServiceImpl.getUser();

    }


}
