package day07;

import java.net.*;

public class InetAddTest {
    public static void main(String[] args) throws UnknownHostException {
        //静态方法：getByName,确定主机名称的id地址
        InetAddress add = InetAddress.getByName("varase");
        System.out.println(add);

        //获得主机的机器名
        String name = add.getHostName();
        System.out.println(name);

        //获得主机的ip地址
        String ip = add.getHostAddress();
        System.out.println(ip);
    }
}
