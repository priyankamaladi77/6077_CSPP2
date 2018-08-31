/**
 * @author PriyankaMaladi.
 */
import java.util.Scanner;
public class Solution {
    /**
     * Do not modify the main function
     * @param args The arguments
    */
    private Solution() {
        // I am not using this constructor
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String actual = sc.nextLine();
        String reverse = reverseString(actual);
        System.out.println(reverse);
    }
    /**
     * Write reverseString function.
     * @param actual The actual.
     * @return { description_of_the_return_value }.
    */
    public static String reverseString(final String actual) {
        String result = "";
        for (int i = 0; i < actual.length(); i++) {
            result = actual.charAt(i) + result;
        }
        return result;
    }
}
