package Directory04;

import Directory01.Point;

public class Globe implements Area, Volume {
    public Point p;
    public double radius;

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume() {
        return 4 / 3 * Math.PI * Math.pow(radius, 3);
    }
}
