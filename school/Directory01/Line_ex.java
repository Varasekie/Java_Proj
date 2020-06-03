package Directory01;

public class Line_ex {
    public static void main(String[] args) {
        Point p1 = new Point(4, 0);
        Point p2 = new Point(0, 3);
        System.out.println("description" + new Line(p1, p2).toString());
        System.out.println("length" + new Line(p1, p2).len());
    }
}
