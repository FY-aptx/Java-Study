import com.fy.pojo.User;
import com.fy.pojo.UserTwo;
import com.sun.org.apache.xpath.internal.CachedXPathAPI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //User user = (User) context.getBean("user2");
        UserTwo user2= (UserTwo) context.getBean("user2");
       // user.show();
        user2.show();
        //System.out.println(user==user2);
    }
}
