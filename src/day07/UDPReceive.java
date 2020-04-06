package day07;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        while (true){
            DatagramSocket ds = new DatagramSocket(8080);

            byte[] b = new byte[1024];

            DatagramPacket dp = new DatagramPacket(b,b.length);
            ds.receive(dp);

            System.out.println(new String(b));
        }
       //直接用死循环来让它不停的获取数据，就不关闭这个口了
    }
}
