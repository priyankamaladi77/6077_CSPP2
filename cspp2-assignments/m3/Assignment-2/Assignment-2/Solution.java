import java.util.Scanner;
/**
    Do not modify this main function.
    */
public class Solution {
/**
 * Fill the main function to print the number of 7's between 1 to n
 * @param args The arguments
 */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int i = 0, count = 0, val = 0;
        while (i < num) {
            if (i % 10 == 7) {
                count += 1;
            }
             i += 1;
        }
        for (int j = 0; j < num; j++) {
            int a = j / 10;
            while (a > 0) {
                if (a % 10 == 7) {
                    val += 1;
                }
                a = a / 10;
            }
            if (a == 7) {
                val += 1;
            }
            
        }
        int res = count + val;
        System.out.println(res);
    }
}
