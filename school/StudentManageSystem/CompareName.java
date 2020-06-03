package StudentManageSystem;

import java.util.Comparator;

public class CompareName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}

class CompareBirth implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.birthday.compareTo(o2.birthday);
    }
}

class CompareNumber implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.number.compareTo(o2.number);
    }
}

class CompareProvince implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.province.compareTo(o2.province);
    }
}

class CompareCity implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.city.compareTo(o2.city);
    }
}

class ComparePolicy implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.policy.compareTo(o2.policy);
    }
}

class CompareAcademy implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.academy.compareTo(o2.academy);
    }
}

class CompareSpeciality implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.speciality.compareTo(o2.speciality);
    }
}