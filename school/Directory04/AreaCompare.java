package Directory04;

import java.util.Comparator;

public class AreaCompare implements Comparator<Area> {
    @Override
    public int compare(Area o1, Area o2) {
        return (int) (o1.area()- o2.area());
    }
}
