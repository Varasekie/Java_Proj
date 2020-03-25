package day03;

public class InnerClass {


    public static void main(String[] args) {
        C c = new C();
        c.useA();
        c.useB();
    }


}

class A {
    public int a = 1;

    public void showA() {
        //内部类可以调用外部类的变量
        System.out.println("内部类A的方法" + a);
    }
}

class B {
    private void showB(int a) {
        System.out.println("B的内部类方法" + a);
    }
}

class C {

    //写了两个函数来调用这个方法
    //变相实现多重继承
    public void useA() {
        new InnerA().showA();
    }

    public void useB() {
        new InnerB().showB();
    }

    //可以实现多重继承，目的是为了一个类里面可以直接使用（重写两个类的方法
    private class InnerA extends A {
        public void showA() {
            System.out.println("A的内部类方法被调用");
        }

    }

    private class InnerB extends B {
        public void showB() {
            System.out.println("B的内部类方法 被调用");
        }
    }
}