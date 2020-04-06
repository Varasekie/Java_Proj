package day05;

import java.io.Serializable;

//只有Serializable这个接口才能让这个对象实现反序列化和序列化
//这个接口里面没有方法要重写
public class Students implements Serializable {

    //搞一个自己定义的序列化值，这样就不会读写数据乱码
    private static final long serialVersionUID = 11L;

    int age;
    String name;

    //用transient修饰，这个变量就不会参与到序列化中
    private transient int test;

    public Students(int age , String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}
