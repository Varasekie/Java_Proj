package Directory03;

import Directory01.Point;

import java.util.List;

public class Line extends Figure implements Comparable<Line> {
    public Point point2;

    //继承方法可以范围从小到大继承（比如private到public
    public Line(Point p1, Point p2) {
        super(p1);
        this.point2 = p2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        super(new Point(x1, y1));
        this.point2 = new Point(x2, y2);
    }

    public double length() {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    public String toString() {
        return "start" + point1.toString() + "end" + point2.toString() + "length" + length();
    }

    @Override
    public int compareTo(Line o) {
        if (this.length() == o.length()) {
            return 0;
        }
        return (this.length() == o.length()) ? 1 : -1;
    }
}
