package day08;

public class FlyDemo{
    private static void useFly(Flying flying){
        flying.flying("hello world");
    }

    public static void main(String[] args) {

        //无参构造法
        useFly(new Flying() {
            @Override
            public void flying(String s) {
                System.out.println(s);
                System.out.println("...");
            }
        });

        //lameda表达式法：
        useFly((String s)->{
            System.out.println(s);
            System.out.println("lameda");
        });
    }
}
