import com.fy.dao.StudentMapper;
import com.fy.dao.TeacherMapper;
import com.fy.pojo.Student;
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

        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void testStudent(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = studentMapper.getStudent2();

        for (Student student : studentList) {
            System.out.println(student);

        }
        sqlSession.close();
    }
}
