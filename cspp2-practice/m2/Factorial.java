import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Factorial {
    /**
     * Empty constructor.
     */
    private Factorial() {
        // I am not using this constructor
    }
    /**
     * main function to print bigger or smaller or equal number.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int factorial = fact(num);
      System.out.println(factorial);
    }
    /**
     * { function _ description }.
     * @param n { parameter _ description }.
     * @return { description_of_the_return_value }.
    */
    public static int fact(final int n) {
       int output;
       if (n == 1) {
         return 1;
       }
       //Recursion: Function calling itself!!
       output = fact(n - 1) * n;
       return output;
    }
}
