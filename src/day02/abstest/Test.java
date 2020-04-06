package day02.abstest;

public class Test {
    public static void main(String[] args) {

        //创建操作类对象，并调用方法
        UseAnimals u1 = new UseAnimals();
        //这里传参，不能传抽象类，只能传
        Cat cat = new Cat();
        u1.useAnimal(cat);
    }
}
