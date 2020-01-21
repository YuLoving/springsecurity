package cn.nj.springsecurity.Test;

import cn.nj.springsecurity.POJO.Student;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * /**
 * Package: cn.nj.springsecurity.Test
 *
 * @Author: zhaotianyu
 * @Date: 2020/1/14
 */
public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student(1,"aa","男", new Date(),"计算机","南京");
        Student s2 = new Student(2,"bb","男", new Date(),"计算机","浙江");
        Student s3 = new Student(3,"cc","男", new Date(),"计算机","浙江");
        Student s4 = new Student(1,"aa","男", new Date(),"计算机","南京");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        System.out.println("原始数据:"+JSON.toJSONString(students));

        /**
         * 集合的筛选
         */
        System.out.println("============ 筛选住在浙江省的学生==========");
        List<Student> list = students.stream().filter(s -> s.getAddress().equals("浙江")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
        System.out.println("============ 筛选id>2的记录==========");
        List<Student> list1 = students.stream().filter(s -> s.getId() > 2).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list1));

        System.out.println("引用对象的去重，引用对象要实现hashCode和equal方法，否则去重无效");
        List<Student> list2 = students.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list2));


    }

}
