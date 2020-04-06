package day06;

public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket s1 = new SellTicket();


        Thread t1 = new Thread(s1,"卖票口1");
        Thread t2 = new Thread(s1,"卖票口2");

        t1.start();
        t2.start();
    }
}
