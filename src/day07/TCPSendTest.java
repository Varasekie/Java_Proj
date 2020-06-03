package day07;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPSendTest {

    public static void main(String[] args) throws IOException {
        //public Socket(String host, int port)法一
        Socket s = new Socket("192.168.1.102",10086);

        //    public Socket(InetAddress address, int port) 法二，两种方法相同
        //Socket s = new Socket(InetAddress.getByName("192.168.1.102"),10086)

        //输出流
         OutputStream os = s.getOutputStream();
         os.write("一个单纯的TCP字符串".getBytes());

         os.close();
    }
}
