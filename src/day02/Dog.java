package day02;

public class Dog {
    //public和private的差别
    public int age;
    private String name = "旺财";

    public void getName() {
        System.out.println(name);
    }


    //可变参数1：使用数组的形式
    public void testGet1(int[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    //可变参数2：java独有的形式：
    public void testGet2(String... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
