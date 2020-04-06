package day05;

import java.io.*;

public class FileOutputdemo {

    //注意，存进流的类是要实现Serializable接口的
    public static void main(String[] args) throws IOException {
        //创建
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Project_total\\JavaProj\\File_test\\printstream.txt"));

        //为了有对象存储进去，我们搞一个学生类
        Students s = new Students(13,"vara");

        oos.writeObject(s);

        oos.close();
    }
}
