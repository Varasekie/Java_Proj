import interfere.Cook;

public class Test extends Rectangle {


    public Test(int length, int width) {
        super(length, width);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public String print() {
        return null;
    }

    public int testOnly(int a ,int b ){
        return a+b;
    }

    public static void main(String[] args) {
        Test test = new Test(3,4);
        test.area();

        Rectangle rectangle = new Test(3,4);


    }
}
