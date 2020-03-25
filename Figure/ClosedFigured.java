public abstract class ClosedFigured extends Figure {
    private String shape;
    public ClosedFigured(Point point1) {
        super(point1);
    }

    public ClosedFigured() {
        super();
    }

    @Override
    public String toString() {
        return null;
    }

    public abstract double area();

    public abstract double perimeter();

    public abstract String print();


}
