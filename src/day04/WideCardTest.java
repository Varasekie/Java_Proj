package day04;

import java.util.ArrayList;
import java.util.List;

public class WideCardTest {
    public static void main(String[] args) {

        Dd d = new Dd();
        List<Integer> list1 = new ArrayList<>();
        d.test(list1);

        //也能转入其他类型
        List<String> list2 = new ArrayList<>();
        d.test(list2);

        //只能传入子类
        List<D> list3 = new ArrayList<>();
        d.test1(list3);

        //只能传入父类
        List<B> list4 = new ArrayList<>();
        d.test2(list4);

        //只能传实现IA接口的类
        List<interfaceTruth> list5 = new ArrayList<>();
        d.test3(list5);
    }
}

class Dd {
    void test(List<?> list) {
    }

    //C1子类
    public void test1(List<? extends C1> list) {
    }

    //C1父类
    public void test2(List<? super C1> list) {
    }

    //实现IA的类
    public void test3(List<? extends IA> list) {
    }

}

//接下来展示一些类之间的关系，某些通配符是有限制的
class A1 {
}

class B extends A1 {
}

class C1 extends B {
}

class D extends C1 {
}

//下面是为了接口调用
interface IA {
};

class interfaceTruth implements IA {
}