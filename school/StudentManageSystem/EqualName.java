package StudentManageSystem;

public class EqualName implements Equalable<Person> {
    @Override
    public boolean equals(Person t1, Person t2) {
        return t1.name.equals(t2.name);
    }
}

class EqualNumber implements Equalable<Person> {
    @Override
    public boolean equals(Person t1, Person t2) {
        Student s1,s2;
        if (t1.equals(t2)){
            return true;
        }
        if (t1 instanceof Student && t2 instanceof Student) {
            s1 = (Student)t1;
            s2=(Student)t2;
            return s1.number.equals(s2.number);
        }
        return false;
    }
}

class EqualCity implements Equalable<Person> {

    @Override
    public boolean equals(Person t1, Person t2) {
        return t1.city.equals(t2.city);
    }
}

class EqualProvince implements Equalable<Person> {
    @Override
    public boolean equals(Person t1, Person t2) {
        return t1.province.equals(t2.province);
    }
}
