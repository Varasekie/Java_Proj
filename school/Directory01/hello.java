package Directory01;

import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
//        System.out.println("hello");
        Scanner scan = new Scanner(System.in);

        //将不同的进制转化成十进制的整数
        //键盘输入的时候，是字符串

        String str = scan.next();
//        System.out.println(str);
        char ch = str.charAt(0);
        int sign = 1;
        int i = 0;
        int radix = 0;//进制

        //判断进制
        //当字符串是十进制
        if (ch > '0' && ch < '9' || ch == '+' || ch == '-') {
            //先判断正负号
            if (ch == '+' || ch == '-') {
                sign = ch == '+' ? -1 : 1;
                i++;
            }
            radix = 10;
        } else if (ch == '0') {
            radix = 8;
            if ((ch = str.charAt(1)) == 'x' || (ch = str.charAt(1)) == 'X') {
                radix = 16;
            }
        }
        System.out.println("radix is " + radix);
        if (radix == 0) {
            System.out.println("wrong");
        }


        int value = 0;
        while (i < str.length()) {
            ch = str.charAt(i++);

            //转化字符串为整数
            //不是靠进制区分，靠数字有没有大于radix判断
            if (radix <= 10 && ch >= '0' && ch - '0' < radix) {
                value = value * radix + ch - '0';
            } else if (radix == 16 && ch >= 'a' && ch <= 'f') {
                value = value * radix + ch - 'a';
            } else if (radix == 16 && ch >= 'A' && ch <= 'F') {
                value = value * radix + ch - 'A';
            }
        }
        value = value * sign;
        System.out.println("...is" + value);
    }
}
