package ThreadAbout.ChangeMessage;

public class BufferMonitor<T> {
    private T obj;
    private boolean isEmpty = true;

    public synchronized void put(T obj) {
        while (!isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e1) {
            }
        }

        this.obj = obj;
        isEmpty = false;
        System.out.println("唤醒");
        this.notify();//唤醒其他的线程
    }

    public synchronized T get() {
        while (isEmpty) {
            try {
                this.wait();
            }catch (InterruptedException e2){}
        }

        isEmpty = true;
        this.notify();
        return obj;
    }
}
