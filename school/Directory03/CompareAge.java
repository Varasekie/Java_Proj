package Directory03;

import java.util.Comparator;

public class CompareAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.birthday.getYear() - o2.birthday.getYear();
    }
}
