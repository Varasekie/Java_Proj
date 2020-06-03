package StudentManageSystem;

public class EqualBirth implements Equalable<Person> {
    @Override
    public boolean equals(Person t1, Person t2) {
        return t1.birthday.equals(t2.birthday);
    }
}
