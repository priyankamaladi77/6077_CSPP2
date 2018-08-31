import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Concatinate {
    /**
    Do not modify this main function.
    */
    private Concatinate() {
        // I am not using this constructor
    }
    /**
     * main function to concatinate the string with Hello.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String result = s.next();
        System.out.println("Hello" + " " + result + "!");
    }
}
