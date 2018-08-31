/**
 * @author PriyankaMaladi.
 */
import java.util.Scanner;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String actual = sc.nextLine();
		String reverse = reverseString(actual);	
		System.out.println(reverse);
		
	}
	//Write reverseString function
	public static String reverseString(String actual) {
		String result = "";
		for (int i = 0; i < actual.length(); i++) {
			result = actual.charAt(i) + result;
		}
		return result;
	}
}
