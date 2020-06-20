package ThreadAbout.ChangeMessage;

public class ReceiveThread<T> extends Thread {
    private BufferMonitor<T> bm;

    public ReceiveThread(BufferMonitor bm) {
        this.bm = bm;
    }

    @Override
    public void run() {
        T obj;
//        super.run();
//        bm.get();
        do {
            obj = bm.get();
            System.out.println(obj+"得到");
        } while (obj != null);
    }
}
