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
     * Removes all.
     *
     * @param text  The text
     *
     * @return return hashmap.
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
    /**
     * similarity function.
     *
     * @param      file1  The file 1
     * @param      file2  The file 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int similarity(final String file1, final String file2) {
        double nume = 0;
        double count1 = 0;
        double count2 = 0;
        final int a = 100;
        final double a2 = 100D;
        Map<String, Integer> mapping1 = removeAll(file1);
        Map<String, Integer> mapping2 = removeAll(file2);
        for (String index1:mapping1.keySet()) {
            for (String index2:mapping2.keySet()) {
                if (index1.equals(index2)) {
    nume += mapping1.get(index1) * mapping2.get(index2);
                }
            }
        }
        for (String index1:mapping1.keySet()) {
            count1 += Math.pow(mapping1.get(index1), 2);
        }
        for (String index2:mapping2.keySet()) {
            count2 += Math.pow(mapping2.get(index2), 2);
        }
        double denom = Math.sqrt(count1) * Math.sqrt(count2);
        return (int) ((((nume / denom) * a2) / a2) * a);
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
        final int hundered = 100;
        try {
        BagofWords f1 = new BagofWords();
        Scanner sc = new Scanner(System.in);
        File input = new File(sc.next());
        File[] listOfFiles = input.listFiles();
        int max = 0;
        String result1 = "";
        int len = listOfFiles.length;
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    result[i][j] = hundered;
                } else {
result[i][j] = BagofWords.similarity(BagofWords.toString(listOfFiles[i]),
                    BagofWords.toString(listOfFiles[j]));
                if (max < result[i][j]) {
                    max = result[i][j];
    result1 = "Maximum similarity is in between "
        + listOfFiles[i].getName() + " and " + listOfFiles[j].getName();
                }
            }
            }
        }
        System.out.print("      \t");
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
        System.out.println("empty directory");
    }
    }
}
