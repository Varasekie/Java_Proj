package day05;

import java.io.File;
import java.io.IOException;

public class FileCreated {

    public static void main(String[] args) {
//        File f = new File("D:\\Project_total\\JavaProj\\File_test\\test1.txt");
//        if (!f.exists()){
//            try {
//                f.createNewFile();//创建新的文件
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(f.exists());
//
//        f.delete();
//        System.out.println("======================");
//
//        //创建单级目录
//        File file = new File("D:\\Project_total\\JavaProj\\File_test\\test1");
//        file.mkdir();
//
//        //创建多级目录
//        File file1 = new File("D:\\Project_total\\JavaProj\\File_test\\test1\\test1的子文件夹\\test的孙文件夹");
//        file1.mkdirs();
//
//        //返回目录下的文件名称
//        File file2 = new File("D:\\Project_total\\JavaProj\\File_test");
//        String[] str = file2.list();
//        //遍历文件
//        for (String string :str){
//            System.out.println(string);
//        }
//
//        //返回目录下的文件列表
//        File[] files = file2.listFiles();
//        for (File ff : files){
//            System.out.println(ff);

        //       }
        File f = new File("D:\\Project_total\\JavaProj\\File_test");
//        System.out.println(f.exists());
        new FileCreated().printFile(f);
    }

    public void printFile(File file) {
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath() + "一个文件");
        } else if (file.isDirectory()) {
            System.out.println(file.getAbsolutePath() + "是文件夹");
            File[] files = file.listFiles();
            for (File f : files) {
                printFile(f);
            }
        }
    }
}
