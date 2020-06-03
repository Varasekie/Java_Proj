package day08;

public class AddableDemo {
    public static void main(String[] args) {
        //匿名内部类
        useAddable(new Addable() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        });

        //lameda
        useAddable((x, y) -> {
            //在里面重写了add方法
            return x + y;
        });
    }

    public static void useAddable(Addable a) {
        int sum = a.add(1, 2);
        System.out.println("sum" + sum);
    }
}
