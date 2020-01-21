package cn.nj.springsecurity.Test;

import cn.nj.springsecurity.POJO.Student;

import java.util.Optional;

/**
 * /**
 * Package: cn.nj.springsecurity.Test
 *
 * @Author: zhaotianyu
 * @Date: 2020/1/15
 */
public class OptionalTest {
    /**
     *   java8   Optional 接口的测试和使用
     *   Optional 类(java.util.Optional) 是一个容器类，代表一个值存在或不存在，
     *          原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 常用方法：
         *
         * Optional.of(T t) : 创建一个 Optional 实例。
         *
         * Optional.empty() : 创建一个空的 Optional 实例。
         *
         * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例。
         *
         * isPresent() : 判断是否包含值。
         *
         * orElse(T t) : 如果调用对象包含值，返回该值，否则返回t。
         *
         * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值。
         *
         * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()。
         *
         * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional。
         */
        Student student = new Student();
        student.setName("周祥");
        OptionalTest test = new OptionalTest();

        test.oldisnull(student);
        System.out.println(test.newisnull(student));
    }

    public void oldisnull(Student student){
        if(student !=null){
            String name = student.getName();
            if(name!=null){
                System.out.println("old sucess");
            }
        }else{
            System.out.println( "old fail");
        }
    }


    public String newisnull(Student student){
        String fail = Optional.ofNullable(student).map(u -> u.getName()).orElse("new fail");
        return fail;
    }



}
