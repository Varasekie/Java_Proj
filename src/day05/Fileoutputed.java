package day05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fileoutputed {
    public static void main(String[] args) throws IOException {
        //写入一个字节
        try {
            //没有找到路径的话，就自己创建一个文件
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt");
            //写进去的其实是ascii的值
            fileOutputStream.write(97);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //一次写多个字节
        byte[] b = new byte[]{97,98,99,100,101,102};
        //打开true开关，就能在后面继续往下写，不会覆盖掉前一次的内容
        FileOutputStream fileOutputStream =  new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt",true);
        fileOutputStream.write(b);

//        fileOutputStream.close();


        fileOutputStream.write(b,1,3);//bcd

        //将字符串转化为字节数组
        byte[] bytes = "hello world".getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}
