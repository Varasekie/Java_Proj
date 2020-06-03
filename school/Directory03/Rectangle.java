package Directory03;

import Directory01.Point;

public class Rectangle extends ClosedFigure {

    protected int length, width;

    public Rectangle(Point p1, int length, int width) {
        super("长方形", p1);
        this.length = length;
        this.width = width;

    }

    public Rectangle(Point p1, Point p2) {
        super("rectangle", p1);
        //法二：用取绝对值的方法
        this.length = Math.abs(p1.x - p2.x);
//        this.length = (p2.x - p1.x > 0) ? p2.x - p1.x : p1.x - p2.x;
        this.width = (p1.y - p2.y > 0) ? p1.y - p2.y : p2.y - p1.y;
    }

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.length = (x1 - x2 > 0) ? x1 - x2 : x2 - x1;
        this.width = (y1 - y2 > 0) ? y1 - y2 : y2 - y1;
    }

    public Rectangle() {
    }

    public Rectangle(Rectangle rectangle) {
        this.length = rectangle.length;
        this.width = rectangle.width;
        this.point1 = new Point(rectangle.point1);
    }

    public String toString() {
        return this.shape + "形状" + "起始点" + this.point1 + "length" + this.length + "width" + this.width;
    }

    @Override
    public double perimeter() {
        return length*2+width*2;
    }

    @Override
    public double area() {
        return length*width;
    }
}
