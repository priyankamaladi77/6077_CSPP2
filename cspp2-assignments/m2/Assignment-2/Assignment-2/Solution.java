import java.util.Scanner;
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
		rootsOfQuadraticEquation(a, b, c);
		
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		int d = (b*b) - (4*a*c);
		double r1 = ((-b) + Math.sqrt(d)) / (2*a);
		double r2 = ((-b) - Math.sqrt(d)) / (2*a);
		System.out.println(r1 + " " + r2);
	}
}
