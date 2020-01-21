package cn.nj.springsecurity.POJO;

import java.util.Date;
import java.util.Objects;

/**
 * /**
 * Package: cn.nj.springsecurity.POJO
 *
 * @Author: zhaotianyu
 * @Date: 2020/1/14
 */
public class Student {

    private int  id;
    private String name;
    private String sex;
    /**
     * 年份（4位数）
     */
    private Date  birth;
    /**
     * 院系
     */
    private String  department;
    /**
     * 地址
     */
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, String name, String sex, Date birth, String department, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.department = department;
        this.address = address;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
        {return true;}
        if (o == null || getClass() != o.getClass())
        {return false;}
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(birth, student.birth) &&
                Objects.equals(department, student.department) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, birth, department, address);
    }


}
