package day03;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTree {
    public static void main(String[] args) {
        //TreeSet会自动排序
        Set<Person> personSet = new TreeSet<>(new Person());

        //由于只能传对象，所以要先实例化对象才行
        Person person1 = new Person(13,"vara");
        Person person2 = new Person(21,"samoyed");
        Person person3 = new Person(10,"hoho");
        Person person4 = new Person(21,"seno2");

        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);

        for (Person p : personSet){
            System.out.println(p.age + "    " + p.name);
        }
    }
}

class Person implements Comparator<Person> {
    int age;
    String name;
    public Person(){

    }

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }


    @Override
    public int compare(Person o1, Person o2) {
        //>=就可以留存相同的东西了
        if (o1.age >= o2.age){
            return 1;
        }else return -1;
    }
}