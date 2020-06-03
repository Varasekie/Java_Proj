package Directory04;

import Directory01.Point;

public class Pixel extends Point {

    private Color color;

    public static interface ColorConstant {
        public static int RED = 0xffff0000;
        public static int Blue = 0xff00ff00;
        public static int GREEN = 0xff0000ff;
        public static int WHITE = 0xffffffff;
        public static int BLACK = 0xff000000;
    }

     static class Color implements ColorConstant {
        private int value;

        public Color(int rgb) {
            this.value = 0xff000000 | rgb;
        }

        public Color(int red, int blue, int green) {
            this.value = 0xff000000 | (red & 0xFF) << 16 | (blue & 0x000000FF) << 8 | (green & 0xFF);
        }

        public Color() {
            this(ColorConstant.BLACK);
        }

        public int getRed() {
            return (this.value >> 16) & 0xff;
        }

        public int getBlue() {
            return (this.value >> 8) & 0xff;
        }

        public int getGreen() {
            return value & 0xff;
        }

        @Override
        public String toString() {
            return "red" + getRed() + "green" + getGreen() + "blue" + getBlue();
        }
    }

    public Pixel(Point p, int colorvalue) {
        super(p);
        //这里创新
        this.color = new Color(colorvalue);//private内部类可以在外部类调用
        this.color.value = 0xff0000ff;//private内部类成员变量也可调用
    }

    public Pixel() {
        //使用内部接口常量，不省略接口名
        this(new Point(), ColorConstant.BLACK);
    }

    @Override
    public String toString() {
        return "color   " + this.color + "   Point  " + super.toString();
    }

}
//外部main函数
class test{
    public static void main(String[] args) {
        Pixel.Color color = new Pixel.Color(255);
        Pixel test = new Pixel(new Point(2,3),255);
        System.out.println(test.toString());
    }
}
