package Directory03;

import Directory01.Point;


public abstract class ClosedFigure extends Figure implements Comparable<ClosedFigure>{


    protected String shape;

    protected ClosedFigure(String shape, Point p) {
        super(p);
        this.shape = shape;
    }

    public int compareTo(ClosedFigure closedFigure) {
        if (this.area()==closedFigure.area()){
            return 0;
        }
        return this.area()>closedFigure.area()?1:-1;
    }

    protected ClosedFigure() {
        this("", new Point(0, 0));
    }

    public abstract double perimeter();

    public abstract double area();

    public void print() {
        System.out.println(this.shape + this.toString() + String.format("perimeter%1.2f,area%1.2f", this.perimeter(), this.area()     ));
    }
}
