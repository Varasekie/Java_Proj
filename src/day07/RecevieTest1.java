package day07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RecevieTest1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10022);

        //创建输出流
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //创建文件
        File f = new File("D:\\Project_total\\JavaProj\\File_test\\ReceiveTest2.txt");
        FileOutputStream fis = new FileOutputStream(f);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        //读数据
        String data = " ";
        while ((data = br.readLine()) != null){

            bw.write(data);
            bw.newLine();
            //控制台输出
            System.out.println(data);
        }

        //给本地反馈
        BufferedWriter bw_send = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw_send.write("一个普通的服务器的反馈");
        bw_send.newLine();
        bw_send.flush();

        //释放资源
        ss.close();
        bw.close();
    }
}
