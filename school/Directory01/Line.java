package Directory01;

public class Line {
    public Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double len() {
        double len = 0;
        len = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return len;
    }

    public String toString() {
        return "a line from (" + p1.x + ","+p1.y + ") to ( " + p2.x +","+ p2.y +")";
    }
}
