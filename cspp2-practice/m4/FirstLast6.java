import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class FirstLast6 {
     /**
      * @variable SIX.
      */
    private static final int SIX = 6;
    /**
    Do not modify this main function.
    */
    private FirstLast6() {
        // I am not using this constructor
    }
    /**
     * main function to print true if the last or first element of array is 6.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] arrays = new int[num];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = s.nextInt();
        }
        if (arrays[0] == SIX || arrays[arrays.length - 1] == SIX) {
            System.out.println(true);
        } else {
            System.out.println(false);
       }
    }
}
