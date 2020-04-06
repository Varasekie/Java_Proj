package day06;

public class MyThredDemo {
    public static void main(String[] args) {
//        MyThread my1 = new MyThread("vara");
//        MyThread my2 = new MyThread("samoyed");
//        MyThread my3 = new MyThread("kimi");

        //设置优先级，这个优先级只是代表获得CPU的几率比较大
//        my1.setPriority(6);
//        my2.setPriority(9);
//        my3.setPriority(2);

//        my1.start();
//        my2.start();
//        my3.start();

        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();

        mt1.setName("关羽");
        mt2.setName("张飞");
        mt3.setName("刘备");

        //刘备做完了才能让关羽张飞执行
        mt3.start();
        try {
            mt3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mt1.start();
        mt2.start();



        //设置主线程
        Thread.currentThread().setName("刘备");

        //设置守护线程，主线程不跑的时候，守护线程也会自动结束
        mt1.setDaemon(true);
        mt2.setDaemon(true);

        mt1.start();
        mt2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
