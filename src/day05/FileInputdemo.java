package day05;


import java.io.*;

public class FileInputdemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInput ois = new ObjectInputStream(new FileInputStream("D:\\Project_total\\JavaProj\\File_test\\printstream.txt"));

        //读取对象
        Object obj = ois.readObject();

        Students s1 = (Students) obj;
        System.out.println(s1.getName() + s1.getAge());

        ois.close();
    }
}
