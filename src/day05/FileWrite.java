package day05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileWrite {
    public static void main(String[] args) throws Exception {
        OutputStreamWriter o1 = new OutputStreamWriter(new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\test6.txt"));
        o1.write("hello world");
        o1.close();

    }
}
