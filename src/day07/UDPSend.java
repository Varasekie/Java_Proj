package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        //打包数据
        //自己封装一个输入流
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String line = " ";
        System.out.println("please input");

        while ((line = bfr.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            } else {
                byte[] b = line.getBytes();
                DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName("192.168.137.1"), 8080);
                ds.send(dp);
            }
        }
        ds.close();
    }
}
