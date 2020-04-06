package day06;

public class BoxDemo {
    public static void main(String[] args) {
        Box box = new Box();

        Customer cus = new Customer(box);
        Producer pro = new Producer(box);

        Thread cus_thread = new Thread(cus);
        Thread pro_thread = new Thread(pro);

        pro_thread.start();
        cus_thread.start();


    }
}
