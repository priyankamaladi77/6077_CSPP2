import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class SumOfNNumbers {
    /**
    Do not modify this main function.
    */
    private SumOfNNumbers() {
        // I am not using this constructor
    }
    /**
     * main function to print sum of N natural numbers.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
