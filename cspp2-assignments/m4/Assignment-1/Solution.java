import java.util.Scanner;
/**
 * @author PriyankaMaladi.
 */
public final class Solution {
	/**
	Fill this main function to print maximum of given array.
	*/
	private Solution() {
        // I am not using this constructor.
    }
    /**
     * main function to find the average of given elements in array.
     * @param args is the parameter for this function.
     */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int max = 0;
		int[] arrays = new int[num];
		for (int i = 0; i < num; i++) {
			arrays[i] = sc.nextInt();
			if (arrays[i] > max) {
				max = arrays[i];
			}
		}
		System.out.println(max);
	}
}
