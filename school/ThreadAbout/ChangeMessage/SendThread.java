package ThreadAbout.ChangeMessage;

public class SendThread<T> extends Thread {
    private T[] objs;
    private BufferMonitor<T> bm;

    public SendThread(T[] objs,BufferMonitor bm){
        this.objs = objs;
        this.bm = bm;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0;i<objs.length;i++){
            bm.put(objs[i]);
            System.out.println("出"+objs[i]);
        }
        bm.put(null);
        System.out.println("end");
    }
}
