package day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyed {
    public static void main(String[] args) throws IOException {
        //先有输入流对象，把文件的东西拿出来


        FileInputStream fileInputStream = new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\test2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\test3.txt");

        int b = 0;
        while ( (b = fileInputStream.read()) !=-1){
            fileOutputStream.write(b);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
