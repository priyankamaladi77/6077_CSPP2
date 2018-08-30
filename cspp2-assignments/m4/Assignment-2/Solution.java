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
        int[][] mat1 = createMatrix(sc);
        int[][] mat2 = createMatrix(sc);
        sc.close();
        int m = getRowSize(mat1), n = getColumnSize(mat1);
        int a = getRowSize(mat2), b = getColumnSize(mat2);
        if ((m != a) || (n != b)) {
            System.out.println("not possible");
        } else {
            printMatrix(getAdd(mat1, mat2, createMatrix(m, n)));
        }
    }
    /**
     * { function_description }.
     *
     * @param addmat The sum matrix
     */
    public static void printMatrix(final int[][] addmat) {
        for (int i = 0; i < getRowSize(addmat); i++) {
            for (int j = 0; j < getColumnSize(addmat) - 1; j++) {
                System.out.print(addmat[i][j] + " ");
            }
            System.out.println(addmat[i][getRowSize(addmat) - 1]);
        }
    }
    /**
     * Gets the add.
     * @param mat1 The matrix 1
     * @param mat2 The matrix 2
     * @param addmat The sum matrix
     * @return The add.
     */
    public static int[][] getAdd(final int[][] mat1,
                                final int[][] mat2,
                                final int[][] addmat) {
        for (int i = 0; i < getRowSize(mat1); i++) {
            for (int j = 0; j < getColumnSize(mat1); j++) {
                addmat[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return addmat;
    }
    /**
     * { function_description }.
     * @param sc The scanner object
     * @return { description_of_the_return_value }
     */
    public static int[][] createMatrix(final Scanner sc) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arrays = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arrays[i][j] = sc.nextInt();
            }
        }
        return arrays;
    }

   /**
     * Creates a matrix.
     *
     * @param      m     { parameter_description }
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] createMatrix(final int m, final int n) {
        return new int[m][n];
    }

    /**
     * Gets the row size.
     *
     * @param      arrays  The array
     *
     * @return     The row size.
     */
    public static int getRowSize(final int[][] arrays) {
        return arrays.length;
    }
    /**
     * Gets the column size.
     *
     * @param      arrays  The array
     *
     * @return     The column size.
     */
    public static int getColumnSize(final int[][] arrays) {
        return arrays[0].length;
    }
}
