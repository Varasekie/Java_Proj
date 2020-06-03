package Directory01;

public class MagicSquare {
    public static void main(String[] args) {
        int num = 3;

        if (num %2 == 0){
            System.out.println("wrong");
            return;
        }

        int[][] matrix ;
        matrix = new int[num][num];
        matrix[0][(num/2)+1] = 1;

    }
}
