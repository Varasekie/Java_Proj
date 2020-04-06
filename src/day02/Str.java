package day02;

import java.util.Scanner;

public class Str {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str  = s.nextLine();

        System.out.println(test(str));
    }

    public static String test(String str){
        String s = new String("");
        System.out.println(str.length());
        for (int i = str.length()-1 ; i >= 0  ; i--){
            s = s +str.charAt(i);
        }
        return s;
    }
}
