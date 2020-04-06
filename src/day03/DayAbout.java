package day03;

import java.util.Date;

public class DayAbout {
    public static void main(String[] args) {
        //表示它被分配到的时间
        Date date = new Date();
        System.out.println(date);
        //当前时间

        //表示从1970年（标准基准时间）开始的时间
        long date1 = 1000*60*60;
        Date d = new Date(date1);
        System.out.println(d);
        //Thu Jan 01 09:00:00 CST 1970

        Date date2 = new Date();
        long time = 1000*60*60;
        date2.setTime(time);
        System.out.println(date2);
    }
}
