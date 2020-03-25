package day02;

public class Person1 extends Person{
    public static String S_static = "子类静态";
    public static String S_unsta = "子类非静态";

    static {
        System.out.println(S_static);
        System.out.println("子类静态");
    }
    //非静态
    {
        System.out.println(S_unsta);
        System.out.println("子类非静");
    }


    public Person1(){
        super("123");
        System.out.println("子类构造器");
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("---------------------------");
        Person1 person1 = new Person1();
    }
}
