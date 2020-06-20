package ThreadAbout.DealingCards;

public class CardBuffer<T> {
    private T obj;
    private boolean isEmpty = true;
    private int number;//人数
    private int order;//取牌的信号量

    public CardBuffer(int number) {
        this.number = number;
    }

    //放牌和取牌
    public synchronized void put(T obj) {
        while (!isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }

        this.obj = obj;
        this.isEmpty = false;
        this.notify();
    }

    public synchronized T get(){
        while (isEmpty){
            try {
                this.wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        this.isEmpty = true;
        this.notify();
        return this.obj;
    }

}
