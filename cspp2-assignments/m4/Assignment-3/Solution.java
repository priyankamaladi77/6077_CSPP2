// Given an String, Write a java method that returns the decimal value for the given binary string.
/**
 * @author PriyankaMaladi.
 */
import java.util.Scanner;
public final class Solution {
/**
 *Do not modify this main function.
 *@param args The arguments
 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			long res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static long binaryToDecimal(final String s) {
		double result;
		int sum = 0;
		int base = 2;
		int j = s.length() - 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
			result = Math.pow(2, j);
			sum += result;
			}
			j = j - 1;
		}
		return sum;
	}
}
