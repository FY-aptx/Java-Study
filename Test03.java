package com.fy.reflection;

public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person=new Student();
        System.out.println("这个人是："+person.name);

        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println("c1===="+c1);
        System.out.println(c1.hashCode());

        //方式二：通过包名获得forname
        Class c2 = Class.forName("com.fy.reflection.Student");
        System.out.println("c2===="+c2);
        System.out.println(c2.hashCode());

        //方式三：通过类名获得（.class）
        Class c3=Student.class;
        System.out.println("c3===="+c3);
        System.out.println(c3.hashCode());

        //方式四：通过内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println("c4===="+c4);
        System.out.println(c4.hashCode());

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println("c5===="+c5);
        System.out.println(c5);
    }

}

class Person{
    public String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    public Student(){
        this.name="学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}
