public abstract class Rectangle extends ClosedFigured {
    private Point point2;
    private Point point3;
    private Point point4;

    private int length;
    private int width;

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(point1);
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public Rectangle(int length,int width){
        super();
    }

    @Override
    public abstract double area();

    @Override
    public abstract double perimeter();

    @Override
    public abstract String print();
}
