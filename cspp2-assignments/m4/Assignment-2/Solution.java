import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        //Empty Constructor.
        // I am not using this constructor.
    }
    /**
     * Fill the main function to print resultant of addition of matrices
     * main function to add matrices of same size.
     * @param args is the parameter for this function.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] mat1 = new int[m][n];
        int [][] mat2 = new int[m][n];
        int [][] add = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                add[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(add[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
