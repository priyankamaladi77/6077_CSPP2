import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Solution {
    /*
    Do not modify this main function.
    */
    private Solution() {
        // I am not using this constructor.
    }
    /**
     * main function to calculate area of the triangle.
     * @param args is the parameter for this function.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        //areaOfTriangle(base, height);
        System.out.println(0.5 * base * height);
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
