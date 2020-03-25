package day04;

import java.lang.annotation.*;

public class Season {
    public static void main(String[] args) {

        //枚举类名.枚举，返回的是一个枚举的对象
        Seasons spring = Seasons.SPRING;
        spring.showInfo();

        //每一次枚举的对象都是单例的
        Seasons spring1 = Seasons.SPRING;
        System.out.println(spring.equals(spring1));
        //返回True
    }
}

enum Seasons{
    //枚举，相当于调用有参的私有构造
    //可以用全大写的方式，替换
    //public static SEASONS spring = new season()
    SPRING("spring","warm"),
    SUMMER("summer","hot"),
    AUTUMN("fall","cool"),
    WINTER("winter","cold");

    private final String name;
    private final String des;


    Seasons(String name ,String des) {
        this.name = name;
        this.des = des;
    }

    public void showInfo(){
        System.out.println(this.des);
    }
}


@Retention(RetentionPolicy.RUNTIME)//注解的生命周期
@Documented//放到文档中去
@Target(ElementType.FIELD)//给类中的属性做注解
@interface TestAnn{
    //当注解不写的时候，默认为0
    public int id() default 0;

    public String des() default " ";
}

class Test1{
    @TestAnn(id = 10,des = "一个注解")
    int name;
}