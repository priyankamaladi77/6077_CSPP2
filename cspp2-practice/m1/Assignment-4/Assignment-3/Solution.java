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
     * main function to convert celcius to fahrenheit.
     * @param args is the parameter for this function.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        //calculateFromDegreesToFarenheit(degreesCelsius);

        System.out.println((degreesCelsius * 1.8) + 32);
    }
    /*
    Need to fill the calculateFromDegreesToFarenheit
    function and print the output
    of fahrenheit.
    */
}
