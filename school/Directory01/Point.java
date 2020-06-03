package Directory01;

public class Point {
    public int x ,y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Point(){
        this(0,0);
    }

    public Point(Point point){
        this.x = point.x;
        this.y = point.y;
    }

    public String toString(){
        return ("x:" + this.x +"  " + "y:" + this.y);
    }
}
