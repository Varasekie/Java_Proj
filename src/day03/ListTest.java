package day03;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        //默认在最后插入数据
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);

        //指定下标插入数据或者集合
        list.add(2,0);
        System.out.println(list);

        //获得索引值
        System.out.println(list.get(3));

        List<Integer> l  =new ArrayList<>();
        l.add(11);
        l.add(22);

        //插入一个集合
        list.addAll(1,l);
        System.out.println(list);

        //改变某个索引对应的值
        list.set(1,0);
        System.out.println(list);

        //获取元素第一次出现的索引
        System.out.println(list.indexOf(2));
        //最后一次出现时候的索引
        System.out.println(list.lastIndexOf(2));

        //根据下标移除
        list.remove(2);
        System.out.println(list);

        //截取(第3个到第5个）
        //包含index2 ，不包含index4
        List<Integer> list1 = list.subList(2,4);
        System.out.println(list1);

        //list的长度
        System.out.println(list.size());
    }
}
