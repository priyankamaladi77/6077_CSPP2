/**
 * @author PriyankaMaladi.
 */
public final class Swap {
    /**
     * Empty constructor.
     */
    private Swap() {
        // I am not using this constructor
    }
    /**
     * main function to print the Hello Priya!!!
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        int x = 5;
        int y = 10;
        int temp;
        temp = x;
        x = y;
        y = temp;
        System.out.println(x + " " + y);
    }
}
