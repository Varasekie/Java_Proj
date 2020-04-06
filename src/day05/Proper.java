package day05;

import java.util.Properties;
import java.util.Set;

public class Proper {
    public static void main(String[] args) {
        //创建集合对象
        Properties prop = new Properties();

        //作为hashmap添加
        prop.put(123,456);

        //作为集合特有
        prop.setProperty("key1","value1");

        //指定的键搜索value
        System.out.println(prop.getProperty("key1"));
        System.out.println("============================");

        //返回一个键集
        Set<String> name = prop.stringPropertyNames();
        for (String key : name){
            System.out.println("键:" + key +"值" + prop.getProperty(key));
        }

    }
}
