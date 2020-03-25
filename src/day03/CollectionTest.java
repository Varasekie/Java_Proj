package day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(6);
        list.add(5);
        System.out.println("the first like"+list);

        //随机排序
        Collections.shuffle(list);
        System.out.println("random sorted :"+list);

        //排序
        Collections.sort(list);
        System.out.println("sorted :"+list);

        //倒序
        Collections.reverse(list);
        System.out.println("reverse :"+list);

        //交换元素
        Collections.swap(list,4,3);
        System.out.println("swap the element"+list);

        //返回集合中的最大值
        System.out.println("the biggest num" + Collections.max(list));
        System.out.println("the biggest num" + Collections.min(list));

        //返回出现次数
        System.out.println(Collections.frequency(list,1));

        //全部替换
        Collections.replaceAll(list,2,5);

        //此外还有同步控制，到之后多线程再写

        //另外一个类
        //根据某特定顺序，（比如某个对象里面的某个值来进行排序）
        Student stu1 = new Student(7, 1);
        Student stu2 = new Student(8, 2);
        Student stu3 = new Student(10, 4);

        List<Student> students = new ArrayList<Student>();
        students.add(stu2);
        students.add(stu1);
        students.add(stu3);

        //遍历一下
        for (Student stu : students) {
            System.out.println("age:" + stu.age + "    grade" + stu.grade);
        }
        System.out.println("======================");
        Collections.sort(students,new Student());

        //再遍历打印一下
        for (Student stu : students) {
            System.out.println("age:" + stu.age + "    grade" + stu.grade);
        }
        System.out.println("=============================");

        //根据conparator的指定顺序，返回最大元素(最小元素就用min
        //Object max(Collection,Comparator)
        Student a = Collections.max(students,new Student());
        System.out.println("the max age :"+ a.age);
    }

}

//为了可以对其进行比较调用Compare的接口，来重写compare方法
//注意这个泛型应该是限定了传入的是Student的类
class Student implements Comparator<Student> {
    int age;
    int grade;

    public Student() {

    }

    public Student(int age, int grade) {
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.age >= o2.age) {
            return 1;
        } else if (o1.age < o2.age) {
            return -1;
        }
        return 0;
    }


}