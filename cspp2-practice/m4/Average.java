import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Average {
    /**
    Do not modify this main function.
    */
    private Average() {
        // I am not using this constructor
    }
    /**
     * main function to find the average of given elements in array.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int sum = 0;
        int[] arrays = new int[num];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = s.nextInt();
                sum += arrays[i];
        }
        int average = (sum) / (arrays.length);
        System.out.println(average);
    }
}
