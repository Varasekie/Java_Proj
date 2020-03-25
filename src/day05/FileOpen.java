package day05;

import java.io.File;

public class FileOpen {
    public static void main(String[] args) {

        //java只能接受绝对路径
        //?只能连接现有的文件？？？
        File f = new File("D:\\Project_total\\JavaProj\\File_test\\helloworld.txt");
        System.out.println(f.exists());

        //母路径+子路径
        File f1 = new File("D:\\Project_total\\JavaProj\\File_test", "helloworld.txt");
        System.out.println(f1.exists());

        //分隔符来写路径
        File f2 = new File("D:\\Project_total\\JavaProj" + File.separator + "File_test\\helloworld.txt");
        System.out.println(f2.exists());

        System.out.println("==============================");
        System.out.println("常用函数");

        //获取文件名或文件夹名称
        System.out.println(f1.getName());

        //获取当前路径
        System.out.println(f1.getPath());

        //可以取相对路径
        File f3 = new File("JavaHwPro/src/day05/FileOpen.java");
        System.out.println(f3.exists());
        System.out.println(f3.getPath());//当时写的是相对路径就会是文件相对路径
        System.out.println(f3.getAbsoluteFile());//绝对路径

        System.out.println("======================================");

        //返回文件的父级目录
        System.out.println(f.getParent());
        System.out.println(f3.getParent());

        f.canRead();//是否可读
        f.canWrite();//是否可写
        f.isDirectory();//是否是文件夹
        f.isFile();//是否是文件
        f.length();//文件的长度
        f.lastModified();//最后一次编辑的时间


    }

}
