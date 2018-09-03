import java.util.Scanner;
/**
 * @author     : priyanka maladi
 */
class InputValidator {
    /**
     * Write the atrributes and methods for InputValidator.
     */
    private String input;
    /**
     * Constructs the object.
     *
     * @param      str   The string
     */
    InputValidator(final String str) {
        this.input = str;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    boolean validateData() {
        int len = input.length();
        final int length = 6;
        if (len >= length) {
            return true;
        }
        return false;
    }
}
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * { item_description }.
     *
     * @param      args  The arguments
     */
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
