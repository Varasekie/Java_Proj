package day04;

public class Test {
    public static void main(String[] args) {
        //相当于在这里指定了，a只能接受String
        A<String> a = new A();
        a.setT("varase");
        System.out.println(a.getT());

        //再指定一个a1
        A<Integer> a1 = new A<>();
        //这个时候不能把a= a1，两者是不一样的

    }
}
//可以规定一个泛型，让某个类中的方法，只能接受一种数据类型
//T是意为Type
class A<T>{
    private T t;

    public void setT(T t){
        this.t = t;
        return;
    }

    public T getT(){
        return t;
    }
}