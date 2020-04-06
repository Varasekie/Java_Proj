package day06;

import java.util.Scanner;

public class Producer implements Runnable {

    private Box box;

    public Producer() {
    }

    public Producer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        System.out.println(" how much bottle of milk put in");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if (i > 0) {
            //传参进去
            this.box.setBottle(i);
        }
    }
}
