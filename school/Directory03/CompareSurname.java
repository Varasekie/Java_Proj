package Directory03;

import java.util.Comparator;

public class CompareSurname implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.name.startsWith(o2.name)){
            return 0;
        }else return o1.name.compareTo(o2.name);
    }
}
