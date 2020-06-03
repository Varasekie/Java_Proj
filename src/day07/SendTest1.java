package day07;

import java.io.*;
import java.net.Socket;

public class SendTest1 {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("192.168.137.1", 10022);

        //从控制台输入流，再到socket输出流输出数据

        //从控制台输入(方式1
//        InputStream in = System.in;
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        //从文本文件输入（方式2
        File f = new File("D:\\Project_total\\JavaProj\\File_test\\ReceiveTest1.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        //输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //读数据
        /*
         * 在这里，会消极等待，服务器不知道已经结束了读数据的内容，需要定义结束标记
         * */
        String len = "";
        while ((len = br.readLine()) != null) {
            //在方法1中的代码
//            if (len.equals("886")) {
//                break;
//            }
            //然后把数据写进去
            bw.write(len);
            bw.newLine();
            bw.flush();
        }

        s.shutdownOutput();
        //定义结束标记

        //本地接受一个服务器的反馈
        BufferedReader br_rec = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = br_rec.readLine();
        System.out.println("发送端得到的反馈" +data);



        br.close();
        bw.close();
        s.close();
    }
}
