package day04;

public class GeneratorTest {
    public static void main(String[] args) {
        B1<Integer> b1 = new B1<>(123);
        System.out.println(b1.test());

        B2 b2 = new B2("vara");
        System.out.println(b2.test());

        C c = new C();
        System.out.println("==================");
        //传入的参数是什么类型，就会是什么类型
        C.test(3);
        c.test3("varase","samoye");
    }
}

//d定义一个泛型接口
interface Generator<T> {
    //定义一个返回值为T的函数
    T test();
}

//写个类实现这个接口
//法一，仍然保留泛型T
class B1<T> implements Generator<T> {
    T t;

    public B1(T t) {
        this.t = t;
    }

    @Override
    public T test() {
        System.out.println("================");
        System.out.println("B1仍然保留T实现test接口");
        return t;
    }
}

//法二：将泛型T具体化

class B2 implements Generator<String> {

    String string;

    public B2(String string) {
        this.string = string;
    }

    @Override
    public String test() {
        System.out.println("================");
        System.out.println("B2固定实现test接口");
        return string;
    }
}

//如果在class上用泛型，那么在这个calss中就能用
class C <E>{
    E e ;
    public static<E> void test(E e){
        //在static中，不能利用class上规定的泛型,（static中不能使用非静态的成员
        //想使用只能自己在static上设定
        System.out.println("静态方法为了使用泛型" + e);
    }
    //只能在方法内部使用这个T
    //无返回值
    public<T> void test1(T t){
        T t1 = t;
    }

    //有返回值
    public<T> T test2(T t){
        return t;
    }

    //形参为可变参数
    @SafeVarargs
    public final <T> void test3(T... str){
        System.out.println("形参为可变参数==================");
        for (T t : str){
            System.out.println(t);
        }
    }
}

