import java.util.Scanner;
/*Given an String, Write a java method that returns.
 *the decimal value for the given binary string.
 */
/**
 * @author PriyankaMaladi.
 */
public final class Solution {
    /**
    *Do not modify this main function.
    */
    private Solution() {
        // I am not using this constructor.
    }
    /**
     * main function to covert binary to decimal value.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String actual = sc.next();
            long res = binaryToDecimal(actual);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     * @param actual { parameter_description }.
     * @return { description_of_the_return_value }.
     */
    public static long binaryToDecimal(final String actual) {
        double ans;
        int sum = 0;
        int base = 2;
        int j = actual.length() - 1;
        for (int i = 0; i < actual.length(); i++) {
            if (actual.charAt(i) == '1') {
            ans = Math.pow(2, j);
            sum += ans;
            }
            j = j - 1;
        }
        return sum;
    }
}
