package day08;

public class EatableDemo {
    public static void main(String[] args) {
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("eat方法");
            }
        });

        //lambda
        useEatable(() ->{
            System.out.println("lambda");
        });
    }

    public static void useEatable(Eatable e){
        e.eat();
    }
}
