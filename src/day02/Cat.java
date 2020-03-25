package day02;

public class Cat {
    int age ;
    String name;
    char type ;

    //驼峰命名
    public void getName(){
        System.out.println(name);
    }

    //根据返回值判断
    void getAge(){
        age = age + 1;
    }

    /*
    * 在某个类里面也可以调用自身的类（套娃）
    * */
    public static void main(String[] args){
        Cat a = new Cat();
        a.name = "helloworld";
        a.getName();
    }
}
