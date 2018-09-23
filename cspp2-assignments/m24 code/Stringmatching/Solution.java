import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
/**
 * Class for bag of words.
 */
class BagofWords {
    /**
     * constructor.
     */
    protected BagofWords() {
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      filename  The filename
     *
     * @return     String representation of the object.
     */
    public static String toString(final File filename) {
        String str = "";
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            StringBuilder s = new StringBuilder();
            while (sc.hasNext()) {
                s.append(sc.next());
                s.append(" ");
            }
            sc.close();
            str = s.toString();
        } catch (Exception e) {
            System.out.println("no file");
        }
        return str;
    }
    /**
     * similar string function.
     *
     * @param      str1  The string 1
     * @param      str2  The string 2
     *
     * @return     { description_of_the_return_value }
     */
    public static double
similarString(final String str1, final String str2) {
        int row1 = str1.length();
        int col1 = str2.length();
        final int a = 100;
        final double a2 = 100d;
        double strLength = row1 + col1;
        int[][] maximum = new int[row1 + 1][col1 + 1];
        int result = 0;
        double similar = 0;
        for (int i = 0; i <= row1; i++) {
            for (int j = 0; j <= col1; j++) {
                if (i == 0 || j == 0) {
                    maximum[i][j] = 0;
} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    maximum[i][j] = maximum[i - 1][j - 1] + 1;
                } else {
                    maximum[i][j] = 0;
                }
                if (result < maximum[i][j]) {
                    result = maximum[i][j];
                }
            }
        }
    similar = Math.round(((result * 2) / strLength) * a2) / a2;
        return (similar * a);
        }
        /**
         * Removes all.
         *
         * @param      text  The text
         *
         * @return     { description_of_the_return_value }
         */
    public static Map removeAll(final String text) {
        String[] word = text.replaceAll("[^a-zA-Z. ]", "")
        .toLowerCase().split(" ");
        Map<String, Integer> mapping = new HashMap<>();
        int freqcount = 0;
        for (int i = 0; i < word.length; i++) {
            if (!mapping.containsKey(word[i])) {
                mapping.put(word[i], 1);
            } else {
                mapping.put(word[i], mapping.get(word[i]) + 1);
            }
        }
        return mapping;
    }
}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * constructor.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        final int a1 = 100;
        try {
        BagofWords f1 = new BagofWords();
        Scanner sc = new Scanner(System.in);
        File input = new File(sc.next());
        File[] listOfFiles = input.listFiles();
        double maximum = 0;
        String result1 = "";
        int len = listOfFiles.length;
        double[][] result = new double[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    result[i][j] = a1;
                } else {
result[i][j] = BagofWords.similarString(BagofWords.toString(listOfFiles[i]),
                    BagofWords.toString(listOfFiles[j]));
                if (maximum < result[i][j]) {
                    maximum = result[i][j];
            result1 = "Maximum similarity is in between "
+ listOfFiles[i].getName() + " and " + listOfFiles[j].getName();
                }
            }
            }
        }
        System.out.print("\t");
        for (int i = 0; i < len; i++) {
            System.out.print("\t" + listOfFiles[i].getName());
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(listOfFiles[i].getName() + "\t");
            for (int j = 0; j < len; j++) {
                System.out.print(result[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println(result1);

    } catch (Exception e) {
        System.out.println("Empty Directory");
    }
    }
}
