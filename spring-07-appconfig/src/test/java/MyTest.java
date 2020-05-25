import com.fy.config.MyConfig;
import com.fy.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.awt.AppContext;

public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user.getName());
    }
}
