package day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class StaticFile {
    //final InputStream in :标准输入流，一般对应键盘输入或者由主机环境
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        System.out.println("请输入");

        int by;
        while ((by=is.read())!=-1){
            //注意这里是要等着键盘输入的
            System.out.print((char)by);
        }


        PrintStream ps = System.out;
        ps.println("helloworld");
        ps.print(10);

        //System.out.println实际上是一个输出流
        System.out.println("hello world");
    }
}
