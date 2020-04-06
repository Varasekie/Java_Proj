package day06;

import day02.Str;

import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    public static void main(String[] args) throws IOException {


        ArrayList<String> a1 = new ArrayList<>();

        //储存字符串元素
        a1.add("vara");
        a1.add("samoyed");
        a1.add("hello world");

        //创建字符缓冲
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Project_total\\JavaProj\\File_test\\day0601.txt"));
        for (String i : a1){

            bw.write(i);
            //空行
            bw.newLine();
            bw.flush();
        }
        bw.close();


    }
}
