import java.util.Scanner;
/**
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int i = 0, count = 0, value = 0;
        while (i < n) {
        	if (i % 10 == 7) {
        		count += 1;
        	}
        	 i += 1;
        }
        for (int j = 0; j < n; j++) {
        	int a = j / 10;
        	while (a > 0) {
        		if (a % 10 == 7) {
        			value += 1;
        		}
        		a = a / 10;
        	}
        	if (a == 7) {
        		value += 1;
        	}
        	
        }
        int result = count + value;
        System.out.println(result);
    }
}
