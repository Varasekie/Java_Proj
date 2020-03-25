package day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyPic {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\index.png");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\index1.png");

        byte[] b = new byte[1024];
        int len = 0 ;
        while ((len = fileInputStream.read())!=-1){
            fileOutputStream.write(len);
        }
    }
}
