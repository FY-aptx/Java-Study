import com.fy.dao.TeacherMapper;
import com.fy.pojo.Teacher;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getTeacher(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @Test
    public void getTeacher2(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher1 = teacherMapper.getTeacher2(1);
        System.out.println(teacher1);

        sqlSession.close();
    }

    @Test
    public void getTeacher3(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher1 = teacherMapper.getTeacher3(1);
        System.out.println(teacher1);


        sqlSession.close();
    }
}
