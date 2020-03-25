package day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileQues {
    public static void main(String[] args) {


        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("Z:\\hello world");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("异常");
            System.out.println("===============");
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
