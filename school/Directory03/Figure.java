package Directory03;

import Directory01.Point;

public abstract class Figure {
    public Point point1;

    //构造方法
   protected Figure(Point p) {

    }

//    public Figure() {
//
//    }

    @Override
    public String toString() {
        return this.point1==null?"":this.point1.toString();
    }
}
