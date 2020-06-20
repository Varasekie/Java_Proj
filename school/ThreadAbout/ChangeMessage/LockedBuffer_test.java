package ThreadAbout.ChangeMessage;

public class LockedBuffer_test {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4};
        BufferMonitor bm = new BufferMonitor();
        new SendThread<Integer>(integers, bm).start();
        new ReceiveThread<Integer>(bm).start();
    }
}
