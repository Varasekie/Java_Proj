package day06;

public class RunTest {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new RunDemo(),"name1");
        RunDemo r1 = new RunDemo();
        Thread t1 = new Thread(r1,"name1");
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        //Thread-0:46
        //name1:49
    }
}
