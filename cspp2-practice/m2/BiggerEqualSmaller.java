import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class BiggerEqualSmaller {
    /**
     * Empty constructor.
     */
    private BiggerEqualSmaller() {
        // I am not using this constructor
    }
    /**
     * main function to print bigger or smaller or equal number.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int varA = scan.nextInt();
        int varB = scan.nextInt();
        if (varA > varB) {
            System.out.println("Bigger");
        } else if (varA < varB) {
            System.out.println("Smaller");
        } else {
            System.out.println("Equal");
        }
    }
}
