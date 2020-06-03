package Directory04;

import Directory03.*;

import java.util.Comparator;

public class CompareArray {

    //value对象数组排序
    //直接插入排序
    public static <T extends Comparable<? super T>> void sort(T[] t) {
        sort(t, true);
    }

    public static <T extends Comparable<? super T>> void sort(T[] t, Boolean src) {
        //比如按生日排序
        for (int i = 1; i < t.length; i++) {
            T value = t[i];
            int j = i - 1;
            //先考虑升序
            while (j > 0 && (src ? value.compareTo(t[j]) < 0 : value.compareTo(t[j]) > 0)) {
                t[j + 1] = t[j--];
            }
            t[j + 1] = value;
        }
    }

    //比较器
    public static <T> void sort(T[] t, boolean src, Comparator<? super T> c) {

        for (int i = 1; i < t.length; i++) {
            T value = t[i];
            int j = i - 1;
            //先考虑升序
            //=**ATTENTION
            while (j >= 0 && (src ? c.compare(t[j], value) < 0 : c.compare(t[j], value) > 0)) {
                t[j + 1] = t[j--];
            }
            t[j + 1] = value;
        }
    }

    //二分查找
    public static <T> int binarySearch(T[] value, T key, Comparator<? super T> c) {
        return binarySearch(value, key, 0, value.length - 1, c);
    }

    public static <T> int binarySearch(T[] value, T key, int begin, int end, Comparator<? super T> c) {
        int left = begin;
        int right = end;
        while (left <= right) {
            int index = (left + right) / 2;
            if (c.compare( value[index],key) == 0) {
                return index;
            }
            if (c.compare( value[index],key) < 0) {
                left = index + 1;
            } else right = index - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Person ps[] = {new Person("test1", new MyDate(2000, 1, 1)),
                new Person("abc", new MyDate(2003, 2, 1))};

        sort(ps, false, new CompareBirth());

        for (int i = 0; i < ps.length; i++) {
            System.out.println(ps[i].toString());
        }

        //二分查找
        Person key = new Person("ab", new MyDate(2003,3,1));
        int i = binarySearch(ps, key, new CompareAge());
        if (i != -1) {
            System.out.println(ps[i].toString());
        }

    }


}
