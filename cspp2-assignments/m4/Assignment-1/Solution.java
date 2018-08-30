import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		int max = 0;
		int[] arrays = new int[num];
		for (int i = 0; i < num; i++) {
			arrays[i] = sc.nextInt();
			if (arrays[i] > max);
			max = arrays[i];	
		}
		System.out.println(max);
	}
}
