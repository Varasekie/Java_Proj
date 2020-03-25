package day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileInputed {
    public static void main(String[] args) throws IOException {
//        //读入单个字符
//        try {
//
//            FileInputStream inputStream = new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt");
//            //int read 会读里面的字节，然后读到最后一个的时候就返回-1
////            int len = inputStream.read();
////            System.out.println(len);
//
//            //如果想循环读处整个文件
//            int len = 0;
//            while ((len = inputStream.read()) != -1) {
//                //char强制数据转化
//                System.out.println((char) len);
//            }
//
//            //一定要有len的原因：如果执行两编read，不就只输入1，3，5，7个字符了么ww
//
//            inputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        FileInputStream fileInputStream = new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt");
        byte[] b = new byte[2];

        //把文件里面的数据读到b里面去
        int len = fileInputStream.read(b);
        System.out.println(len);
        //toString是打印的Ascii码值
//        System.out.println(Arrays.toString(b));
        System.out.println(new String(b));
        System.out.println("==================");

        //每一次执行read，指针都会往后走，
        len  = fileInputStream.read(b);
        System.out.println(len);
        System.out.println(new String(b));
        System.out.println("==================");


        len  = fileInputStream.read(b);
        System.out.println(len);
        System.out.println(new String(b));

        fileInputStream.close();


    }
}
