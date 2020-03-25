package day05;

import java.io.*;

public class FileBuffer {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\test5.txt");
        FileInputStream fileInputStream = new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\test3.txt");

        //字节缓冲输出流：
        //向里面写数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(1234);
        bufferedOutputStream.write(97);
        bufferedOutputStream.close();

        //输入流
        //我们读取数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //第一，一个个字节
        int by;
        while ((by = bufferedInputStream.read()) != -1){
            System.out.println((char)by);
        }
        //第二：多个字节一读
        byte[] b = new byte[1024];
        while ((by = bufferedInputStream.read(b)) != -1){
            System.out.println(new String(b,0,by));
        }


    }


}
