package Directory03;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Comparator;
//委托模型
public class CompareName implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
//class CompareBirth implements Comparator<Person>{
//
//}

//class CompareAge implements Comparator<Person>{
//
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getAge() - o2.getAge();
//    }
//}

//class CompareSurname implements Comparator<Person>{
//    @Override
//    public int compare(Person o1, Person o2) {
////        char o1_surname = o1.name.charAt(0);
////        char o2_surname = o2.name.charAt(0);
////
////        return o1_surname-o2_surname;
////        return o1.name.charAt(0)-o2.name.charAt(0);
//        if (o1.name.startsWith(o2.name)){
//            return 0;
//        }else return o1.name.compareTo(o2.name);
//    }
//}
