package day07;

import java.io.IOException;
import java.net.*;

public class UDPReceiveTest {
    public static void main(String[] args) throws IOException {
        //先定义一个接收端
        DatagramSocket ds = new DatagramSocket(10086);

        //在定义一个接收的数据包
        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b,b.length);

        ds.receive(dp);
        //解析数据包
        //获取数据
        byte[] data = dp.getData();
        String s = new String(data);
        System.out.println(s);

        ds.close();
    }
}
