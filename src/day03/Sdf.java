package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sdf {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();

        //从date到String
        SimpleDateFormat sdf = new SimpleDateFormat();
        String s = sdf.format(d);
        System.out.println(s);//20-3-26 下午3:20

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时 mm分 ss秒");
        //2020年03月26日 15时 22分 42秒
        String s1 = sdf1.format(d);
        System.out.println(s1);

        //String到Date
        String str = "20-3-26 3:22";
        SimpleDateFormat sfd2 = new SimpleDateFormat("yy-M-dd mm:ss");
        Date dd = sfd2.parse(str);
        System.out.println(dd);
    }
}
