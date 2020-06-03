package Directory01;

public class pyramid {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int k = n - i + 1; k > 1; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j <= i) {
                    num++;
                } else if (j > i && num >= 1) {
                    num--;
                }
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
