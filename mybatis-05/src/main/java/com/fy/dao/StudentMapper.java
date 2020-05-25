package com.fy.dao;

import com.fy.pojo.Student;
import java.util.List;

public interface StudentMapper {
    //查询所有的学生的信息以及对应的老师的信息

    List<Student> getStudent();

    List<Student> getStudent2();
}
