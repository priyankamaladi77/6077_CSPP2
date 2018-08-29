import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Pattern {
    /**
    Do not modify this main function.
    */
    private Pattern() {
        // I am not using this constructor
    }
    /**
     * main function to print pattern.
     * @param args is the parameter for this function.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
