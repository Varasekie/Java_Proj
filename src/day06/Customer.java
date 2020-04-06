package day06;

public class Customer implements Runnable {

    private Box box;

    public Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
       this.box.getBottle();
    }
}
