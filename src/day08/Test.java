package day08;

public class Test {
    public static void main(String[] args) {
        //如果参数有且仅有一个，可以省略小括号
        //如果只有一条代码，可以省略大括号和分号
        useFlyable(s -> System.out.println(s));
        //如果代码块语句只有一条，可以省略大括号和分号，如果有return，return也要省略
        useAddable(((x, y) -> x + y));
    }

    public static void useFlyable(Flying f) {
        f.flying("一个s字符串");
    }

    public static void useAddable(Addable a) {
        int sum = a.add(10, 20);
        System.out.println(sum);
    }
}
