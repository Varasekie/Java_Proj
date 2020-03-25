package day02;

public class Person {
    public int age = 18;
    public String name;
    private String number;

    public Person(String number){
        this.number = number;
        this.age = 18;
    }


//    public boolean equals(Object object){
//        if (this == object){
//            return true;
//        }
//        if (object instanceof day02.Person){
//            return this.name.equals()
//        }
//    }

    public void setNumber(String number){
        this.number = number;
        return;
    }

    public String getNumber(String number){
        return number;
    }

    public Person(Person person){
        //直接传入一个类，tql
        //使可以直接将某一套的默认值，套到一个新的地方
        this.age = person.age;
        this.name = person.name;
    }

    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    public Person() {
        //利用引用,直接赋值
        this (2,"bara");
        //System.out.println("构造器");
    }
//    初始化块：是不能接受任何的参数的，本质是构造器的一种补充，先运行初始化快，在运行构造器
//    静态初始化块，只能接收静态的成员
    public static String p_static = "父类静态变量";
    public String p_unsta = "父类变量";
    static {
        System.out.println(p_static);
        System.out.println("父类的静态");
    }
    //非静态初始化块
    {
        System.out.println(p_unsta);
        System.out.println("父类的非静态");

    }


    public void showInfo(){
//        System.out.println(this.age);
//        System.out.println(this.name);
        System.out.println("parent showInfo");
    }
}
