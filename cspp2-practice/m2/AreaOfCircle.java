import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class AreaOfCircle {
    /**
     * @variable PIVALUE
     */
    private static final double PIVALUE = 3.14;
    /**
     * Empty constructor.
     */
    private AreaOfCircle() {
        // I am not using this constructor
    }
    /**
     * main function to find the area of the circle.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println(area(a));
    }

    /**
     *method to calculate area of the circle.
     *@param radius is the parameter
     *@return double value of area of circle
     */
    public static double area(final int radius) {
        return (pi() * radius * radius);
    }
    /**
     * method pi to return pi value.
     * @return pi value
     */
    public static double pi() {
        return PIVALUE;
    }
}
