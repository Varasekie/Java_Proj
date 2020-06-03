package Directory06;

public class RMB {
    public static String toString(double x) {
        String yuan = "亿仟佰拾万仟佰拾元角分";
        String digit = "零壹贰叁肆伍陆柒捌玖";
        String result = "";
        int y = (int) (x * 100);
        for (int i = digit.length() - 1; y > 0 && i > 0; i--, y /= 10) {
            //单独输出不变成数字
//            System.out.println("digit.charAt(y % 10)显示为" + digit.charAt(y % 10) + "    yuan.charAt(i)显示为" + yuan.charAt(i));
            //会变成数字
//            System.out.println("digit.charAt(y % 10) + yuan.charAt(i)显示为");
//            System.out.println(digit.charAt(y % 10) + yuan.charAt(i));
//            System.out.println("=========================分割一次循环");
            result = "" + digit.charAt(y % 10) + yuan.charAt(i) + result;
        }
        return result;
    }
}