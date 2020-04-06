package day07;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    public static void main(String[] args) throws IOException {
        //创建socket对象（DatagramSocket)
        //构造数据报套接字并绑定到任何一个可用端口
        DatagramSocket s1 = new DatagramSocket();

        //创建数据，打包数据
        //DatagramPacket(byte[] buf , int length ,InetAddress address , int port )
        //发送长度length的数据到主机上的指定端口号
        byte[] b = "一个平平无奇的字符串from varase".getBytes();
        int len = b.length;
        InetAddress add = InetAddress.getByName("192.168.137.1");
        //最后这个接口port是随便写的
        DatagramPacket dp = new DatagramPacket(b,len,add,10086);

        //调用方法发送数据send（）
        s1.send(dp);
        //关闭发送端
        s1.close();
    }
}
