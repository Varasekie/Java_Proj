package day05;

import java.io.*;

public class FileRead {
    public static void main(String[] args) throws Exception {
        //字符缓冲流写数据
        //是字节流到字符流的一个桥接而已，创建一个使用默认字符编码的OutputStreamWriter
        OutputStreamWriter f1 = new OutputStreamWriter(new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt"));
        char[] chars = new char[]{'a','b','c'};

        f1.write(97);
        //只有刷新才能写的进来
        f1.flush();
        f1.write(99);

        f1.write(chars,0,2);
        f1.flush();

        f1.write("这是一个中文",0,3);
        f1.close();

        //字符流读数据
        InputStreamReader f2 = new InputStreamReader(new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt"));

        int len = 0 ;
        while ((len = f2.read())!= -1){
            System.out.print((char)len);
        }
        //同理，利用byte读也是可以的

        //缓冲区
        FileWriter f3 = new FileWriter("D:\\Project_total\\JavaProj\\File_test\\test2.txt");
        BufferedWriter f = new BufferedWriter(f3);
        f.write("hello\r\n");
        f.flush();
        f.close();

        FileReader f4 = new FileReader("D:\\Project_total\\JavaProj\\File_test\\test2.txt");
        BufferedReader ff = new BufferedReader(f4);
        System.out.println(ff.read());
        ff.close();





    }
}
