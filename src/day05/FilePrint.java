package day05;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FilePrint {
    public static void main(String[] args) throws FileNotFoundException {

        //指定文件名创建新的文件流
        PrintStream ps = new PrintStream("D:\\Project_total\\JavaProj\\File_test\\printstream.txt");

        ps.write(97);//写入a

        ps.println();
        ps.print(97);//写入97

        ps.close();

        //构造方法1
        PrintWriter pw = new PrintWriter("D:\\Project_total\\JavaProj\\File_test\\printstream.txt");
        pw.write("hello");
        pw.flush();
        pw.println();
        pw.write("world");

        pw.close();

        //构造方法2
        //这种方法可以自动刷新
        PrintWriter pw1 = new PrintWriter(new PrintStream("D:\\Project_total\\JavaProj\\File_test\\printstream.txt"),true);
    }
}
