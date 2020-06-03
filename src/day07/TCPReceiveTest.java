package day07;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiveTest {
    public static void main(String[] args) throws IOException {
        //public ServerSocket(int port)
        ServerSocket ss = new ServerSocket(10086);

        //在监听到客户端有链接之后，自动生成socket对象,再用这个对象获取inputstream
        Socket s = ss.accept();

        InputStream is = s.getInputStream();

        byte[] b = new byte[1024];
        int len = is.read(b);
        String data = new String(b,0,len);
        System.out.println(data);

        //要注意因为是中文字符，所以不能用这种读数据的方式……
//        int len = 0;
//        while ((len = is.read()) != -1) {
//            System.out.println();
//        }
        ss.close();
        s.close();
    }
}
