/**
 * @author PriyankaMaladi.
 */
public final class ConverttoWhileLoop {
    /**
    Do not modify this main function.
    */
    private static final int A = 10;
    /**
     * Constructs the object.
     */
    private ConverttoWhileLoop() {
        // I am not using this constructor
    }
    /**
     * main function to print the even numbers till 10 and Goodbye!.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        int i = 0;
        while (i < A) {
            i = i + 2;
            System.out.println(i);
        }
        System.out.println("GoodBye!");
    }
}
