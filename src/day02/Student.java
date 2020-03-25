package day02;

public class Student extends Person{

    public Student(){
        super("123");
        age = 13;
        name = "vara";
    }

    public void showInfo(){
        //super.showInfo();
        System.out.println(" student showInfo");
    }

    public void getschool(){
        System.out.println("需要强制转化");
    }

    public static void main(String[] args) {
        //copy构造方法
        Person p1 = new Person(13,"vara");
        Person p2 = new Person(p1);

        System.out.println(p2.age);
    }
}
