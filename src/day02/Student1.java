package day02;

public class Student1 extends Person {
    private String number;
    private int grade;


    //要求
    public Student1(String number){
        super(number);
        this.number = "123";
    }

    //重写
    public void setNumber(){
        this.number = this.number + "helloworld";
        return;
    }

    public String getNumber(){
        return "所有的number是" + this.number + "ww" + this.number;
    }

    public static void main(String[] args) {
        Student1 student1 = new Student1("123");
        student1.setNumber();
        //已经改变了number了
        System.out.println(student1.number);
        String str = student1.getNumber();
        System.out.println(str);
    }
}
