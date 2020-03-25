package Compet;


public class Three {
    public static void main(String[] args) {
        //虽然不知道怎么获取数组……
        int total = 0;
        int[] a = {1, 2, 5, 3, 5};
        int[] b = {0,0,0,0,0};

        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++){
                for (int z = j+1 ; z<a.length ;z++){
                    if (a[i] < a[j] && a[j]<a[z]&&b[j] != 1){
                        total++;
                        b[j] = 1;
                    }
                }
            }
        }
        System.out.println(total);


    }
}
