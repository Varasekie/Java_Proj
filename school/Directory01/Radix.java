package Directory01;

public class Radix {
    public static void main(String[] args) {
//        int i = 21;
//        char ch = (char) (i + 48);
//        System.out.println(ch);
        int[][] i =create(3);
        print(i);
    }

    public static void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] create(int n) {
        int[][] mat = new int[n][];
        for (int i = 0; i < n; i++) {
            mat[i] = new int[2 * i + 1];
        }
        return mat;
    }
}
