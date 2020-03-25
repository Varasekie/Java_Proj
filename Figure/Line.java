public abstract class Line extends Figure {
    private Point point2;
    private Point point1;

    protected Line(Point point1, Point point2) {
        super(point1);
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return null;
    }

    public double length(Point point2) {
        double length;
        int x = point1.getX() - point2.getX();
        int y = point1.getY() - point2.getY();

        length = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
        return length;
    }

}
