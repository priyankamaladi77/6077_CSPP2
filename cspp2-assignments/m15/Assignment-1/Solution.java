import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * List of Integer.
 * @author    Priyanka Maladi.
 */
class InvalidPositionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidPositionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling index outof bounds errors.
 */
class IndexOutofBoundsException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    IndexOutofBoundsException(final String s) {
        super(s);
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { var_description }.
     */
    private int[] list;
    /**
     * { var_description }.
     */
    private int size;
    /**
      * @variable TEN.
      */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    public Solution() {
        list = new int[TEN];
        size = 0;
    }

    /**
     * add method.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size > list.length) {
            resize();
        }
        list[size++] = item;
    }

    /**
     * size method.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }

    /**
     * remove method.
     *
     * @param      index                     The index
     *
     * @throws     InvalidPositionException  { exception_description }
     */
    public void remove(final int index) throws InvalidPositionException {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
           throw new InvalidPositionException("Invalid Position Exception");
        }
    }

    /**
     * get method.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }

    /**
     * contains method.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        return indexOf(item) == -1;
    }

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds all.
     *
     * @param      newArray  The new array
     */
    public void addAll(final int[] newArray) {
        if (newArray.length + size >= list.length) {
            resize();
        }
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }

    /**
     * resize method.
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }

    /**
     * add method.
     *
     * @param      item   The item
     * @param      index  The index
     */
    public void add(final int item, final int index) {
        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = item;
    }
    /**
     * count method.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int item) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (item == list[j]) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Removes all.
     *
     * @param      newArray  The new array
     */
    public void removeAll(final int[] newArray) {
        if (newArray.length < list.length) {
            for (int i = 0; i < newArray.length; i++) {
            int index = indexOf(newArray[i]);
            while (index != -1) {
                try {
                    remove(index);
                index = indexOf(newArray[i]);
            } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    /**
     * sublist method.
     *
     * @param      start                      The start
     * @param      end                        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     IndexOutofBoundsException  { exception_description }
     */
    public Solution subList(final int start, final int end)
     throws IndexOutofBoundsException {
        //int[] list = new int[end - start];
        Solution newlist = new Solution();
        if ((start == end) && (start <= 0 && end <= 0)) {
            throw new
            IndexOutofBoundsException("Index Out of Bounds Exception");
        }
        if (start == end) {
            return newlist;
        } else if ((start < 0 || end < 0) || (start > size || end > size)) {
            throw new
            IndexOutofBoundsException("Index Out of Bounds Exception");
        } else if ((start >= 0 && start < end) && (end > 0 && end > start
            && end < list.length)) {
            int k = 0;
            for (k = start; k < end; k++) {
                newlist.add(list[k]);
            }
        }
        return newlist;
    }

    /**
     * equals method.
     *
     * @param      list1  The list 1
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final Solution list1) {
        return list1.toString().equals(this.toString());
    }

    /**
     * clear method.
     */
    public void clear() {
        size = 0;
    }

    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Solution l = new Solution();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        } else if (t.length == 2) {
                            l.add(Integer.parseInt(t[0]),
                                Integer.parseInt(t[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    try {
                        if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    }
                break;
                case "subList":
                    try {
                        if (tokens.length != 2) {
                            break;
                        }
                    String[] arrstring3 = tokens[1].split(",");
                    Solution object = l.subList(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    break;
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        Solution l2 = new Solution();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                case "count":
                    if (tokens.length == 2) {
                        System.out.println(l.count(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                default:
                break;
            }
        }
    }
}
