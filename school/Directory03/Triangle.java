package Directory03;

import Directory01.Point;

public class Triangle extends ClosedFigure {
    public Point p1;
    public Point p2;
    public Point p3;

    public double a, b, c;

    public Triangle(Point p1, Point p2, Point p3) {
        super("triangle", p1);
        this.p2 = p2;
        this.p3 = p3;
        this.a = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        this.b = Math.sqrt(Math.pow(p2.x - p3.x, 2) + Math.pow(p2.y - p3.y, 2));
        this.c = Math.sqrt(Math.pow(p1.x - p3.x, 2) + Math.pow(p1.y - p3.y, 2));
    }

    @Override
    public double perimeter() {
        double perimeter = a + b + c;
        return perimeter;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
