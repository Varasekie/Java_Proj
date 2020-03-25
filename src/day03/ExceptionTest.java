package day03;

public class ExceptionTest {
    private static int i = 0;


    public static void main(String[] args) {
        //注意异常的抛出和捕获都要在main函数里面

        //try括住可能出现异常的代码串

//        try {
//            System.out.println("try里的代码1");
//            System.out.println(3 / i);
//            //接下来的代码不被打印
//            System.out.println("try里面的代码2");
//        } catch (Exception e) {//不知道异常是什么的时候，直接用exception类
//            //e.printStackTrace();
//            System.out.println(e.getMessage());
//
//            System.out.println("catch里面的代码");
//        } finally {
//            System.out.println("final必须执行的方法");
//        }
//        int i = 0;
//        String[] strings = new String[]{"1","2"};
//        try {
//            System.out.println(3/i);
//            System.out.println(strings[2]);
//        }catch (ArithmeticException e1){
//            System.out.println("/0的错误");
//        }catch (ArrayIndexOutOfBoundsException e2){
//            System.out.println("数组越界");
//        }
        D d = new D();
        //会要求补全try catch，否则会报错
//        try {
//            d.day02.test();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            d.age(19);
        } catch (MyException e) {
            e.printStackTrace();
        }


    }

}

class D {
    public int i = 0;
    public void test() throws Exception{
        D d = null;
        System.out.println(d.i);
    }

    public void age(int age) throws MyException{
        if (age >= 0 && age<= 18){
            System.out.println("age正常打印"+ age);
        }else {
            //控制数据的大小抛出一个自定义的异常
            throw new MyException("自定义的exception");
        }
    }
}

class E extends D{
    public int i = 0;
    public void test() throws NullPointerException{
        D d = null;
        System.out.println(d.i);
    }
}

//自定义一个exception
class MyException extends Exception{
    //本来exception类中传进来的就可以是一个自定义的String
    public MyException(String e){
        //注意这边要传进来，父类的构造方法
        super(e);
    }
}