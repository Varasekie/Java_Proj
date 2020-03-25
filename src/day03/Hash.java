package day03;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
public class Hash {
    public static void main(String[] args) {
        Set set = new HashSet();

        //增加数据：add（）函数
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        //删除数据，remove里面的参数是对象
        set.remove(1);
        System.out.println(set);

        //判断是否包含
        System.out.println(set.contains(1));

        //全部清空
        set.clear();
        System.out.println(set);
        System.out.println("=====================");

        set.add(1);
        set.add(2);
        set.add(3);
        //遍历集合：
        //1. 利用迭代器
        Iterator iterator = set.iterator();//iterator的作用是返回一个迭代器（迭代器是一个接口
        while (iterator.hasNext()){
            //当有next的时候，打印下一个
            System.out.println(iterator.next());
        }

        System.out.println("==============");

        //2.利用for循环
        for (Object object : set){//把set中的值拿出来，一个个赋值给object，然后再打印object
            System.out.println(object);
        }

        //集合的大小
        System.out.println(set.size());

        //不可重复特性：
        set.add(3);
        //并没有增加数字
        System.out.println(set);

        //使用泛型，规定某个set里面只能有某一种数据类型
        //一定是对象类的
        Set<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(22);

        System.out.println(set1);
    }
}
