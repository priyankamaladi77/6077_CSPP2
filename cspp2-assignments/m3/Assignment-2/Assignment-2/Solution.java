import java.util.Scanner;
/**
 * @author     PriyankaMaladi.
 */
public final class Solution {
    /**
    Do not modify this main function.
    */
    private static final int A = 10;
    /**
     * Constructs the object.
     */
    private static final int B = 7;
    /**
     * Constructs the object.
     */
    private Solution() {
        // I am not using this constructor
    }
    /**
     * main function to print number of 7 in given range.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int i = 0, count = 0, val = 0;
        while (i < num) {
            if (i % A == B) {
                count += 1;
            }
             i += 1;
        }
        for (int j = 0; j < num; j++) {
            int a = j / A;
            while (a > 0) {
                if (a % A == B) {
                    val += 1;
                }
                a = a / A;
            }
            if (a == B) {
                val += 1;
            }
        }
        int res = count + val;
        System.out.println(res);
    }
}
