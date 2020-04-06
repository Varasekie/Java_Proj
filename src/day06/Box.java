package day06;

public class Box {
    public int bottle = 0;

    //state监视器,一开始没有牛奶
    private boolean state = false;

    public synchronized void setBottle(int bottle) {
        this.bottle = bottle;
        if (state){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("set bottle error");
            }
        }

        //下面是没有的状态
        System.out.println("producer produce the " + bottle + "bottle of milk");
        notifyAll();
    }

    public synchronized void getBottle() {
        if (!state){
            try {
                wait(100000);
            } catch (InterruptedException e) {
                System.out.println("get bottle error");
            }
        }
        System.out.println("customers get the " + this.bottle + " bottle");
        notifyAll();
    }
}
