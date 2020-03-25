package day02;

public class kk extends Kids{
    public void test() {
        //继承父类的成员变量
        super.yearsOld = 1;
        super.sex = 1;

        //注意，继承只能非static继承非static
        //static类继承static类
        //父类的方法
        super.printAge();

        //调用父类（重写过）的方法
        super.employeed();

    }

//    public static void main(String[] args) {
//        day02.kk k1 = new day02.kk();
//        //k1.printAge();
//        //k1.employeed();
//
//        //在方法中，对父类的方法进行了引用
//        k1.day02.test();
//    }
}
