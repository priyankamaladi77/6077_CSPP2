import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	Do not modify this main function.
	@param args The arguments
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		roots(a, b, c);
	}
	/**
	Need to write the roots function and print the output.
	@param      a     { parameter_description }
	@param      b     { parameter_description }
	@param      c     { parameter_description }
	*/
	public static void roots(final int a, final int b, final int c) {
		int d = (b * b) - (2 * 2 * a * c);
		double r1 = ((-b) + Math.sqrt(d)) / (2 * a);
		double r2 = ((-b) - Math.sqrt(d)) / (2 * a);
		System.out.println(r1 + " " + r2);
	}
}
