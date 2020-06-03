package Directory03;

import Directory01.Point;

public class Polygon extends ClosedFigure {
    private Point[] points;

    public Polygon(Point[] p) {
        super("多边形", p[0]);
        this.points = p;
    }

    @Override
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.length; i++) {
            perimeter += new Line(points[i], points[(i + 1) % points.length]).length();
        }
        return perimeter;
    }

    @Override
    public double area() {
        double sum = 0;
        for (int i = 1; i < points.length; i++) {
            sum += new Triangle(points[0], points[i], points[i + 1]).area();
        }
        return sum;
    }
}
