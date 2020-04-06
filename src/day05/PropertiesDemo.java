package day05;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {

        myStore();
        myLoad();

    }

    private static void myLoad() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("key1","value1");
        prop.setProperty("key2","value2");
        prop.setProperty("key3","value3");

        //load函数
        FileReader fr = new FileReader("D:\\Project_total\\JavaProj\\File_test\\store.txt");
        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("key1","value1");
        prop.setProperty("key2","value2");
        prop.setProperty("key3","value3");

        //store()函数
        FileWriter fw = new FileWriter("D:\\Project_total\\JavaProj\\File_test\\store.txt");
        prop.store(fw,"hello world");
        fw.close();
    }
}
//#hello world
//#Wed Apr 01 17:08:20 CST 2020
//key3=value3
//key2=value2
//key1=value1
