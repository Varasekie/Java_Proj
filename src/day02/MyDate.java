package day02;

public class MyDate {
    private int year;
    private int month;
    private int date;

    public MyDate(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public boolean equals(Object object) {
        if (object instanceof MyDate) {
            MyDate myDate = (MyDate) object;
            if (myDate.date == this.date && myDate.month == this.month && myDate.year == this.year) {
                return true;
            } else return false;
        } else return false;
    }

    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(1999,5,23);
        MyDate myDate2 = new MyDate(1999,5,23);
        MyDate myDate3 = new MyDate(2001,8,18);

        boolean a = myDate1.equals(myDate2);
        System.out.println(a);

        boolean b = myDate2.equals(myDate3);
        System.out.println(b);
    }
}
