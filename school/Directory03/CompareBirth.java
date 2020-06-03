package Directory03;

import java.util.Comparator;

public class CompareBirth implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.birthday.compareTo(o2.birthday);
    }
}
