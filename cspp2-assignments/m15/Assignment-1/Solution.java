import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * List of Integer.
 * @author Priyanka Maladi.
 */
class InvalidPositionException extends Exception {
	InvalidPositionException(String s) {
		super(s);
	}
}
class IndexOutofBoundsException extends Exception {
	IndexOutofBoundsException(String s) {
		super(s);
	}
}
public class Solution {
	private int[] list;
	private int size;

	public Solution() {
		list = new int[10];
		size = 0;
	}

	public void add(int item) {
		if(size > list.length) {
			resize();
		}
		list[size++] = item;
	}

	public int size() {
		return size;
	}

	public void remove(int index) throws InvalidPositionException{
		if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
           throw new InvalidPositionException("Invalid Position Exception");
        }
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
	}

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

	public boolean contains(int item) {
		return indexOf(item) == -1;
	}

	public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }

    public void addAll(int[] newArray) {
        if (newArray.length + size >= list.length) {
            resize();
        }
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }

    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }

    public void add(int item, int index) {
    	for (int i = size - 1; i >= index; i--) {
    		list[i + 1] = list[i];
    	}
    	list[index] = item;
    }
    public int count(final int item) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (item == list[j]) {
                count += 1;
            }
        }
        return count;
    }

    public void removeAll(final int[] newArray) {
        boolean check;
        for (int i = 0; i < newArray.length; i++) {
            check = contains(newArray[i]);
            if (check) {
                for (int j = 0; j < size; j++) {
                    if (list[j] == newArray[i]) {
                        try {
                        	remove(j);
                        } catch (Exception e) {
                        	System.out.println(e.getMessage());
                        }
                        j--;
                    }
                }
            }
        }
     }

     public Solution subList(int start, int end)  throws IndexOutofBoundsException {
    	//int[] list = new int[end - start];
    	Solution newlist = new Solution();
    	if ((start == end) && (start <= 0 && end <= 0)) {
    		throw new IndexOutofBoundsException("Index Out of Bounds Exception");
    	} if (start == end) {
    		return newlist;
    	} else if ((start < 0 || end < 0) || (start > size || end > size)){
    		throw new IndexOutofBoundsException("Index Out of Bounds Exception");
    	} else if ((start >= 0 && start < end) && (end > 0 && end > start && end < list.length)) {
    		int k = 0;
    		for (k = start; k < end; k++) {
    			newlist.add(list[k]);
    		}
    	}
    	return newlist;
    }

    public boolean equals(final Solution list1) {
    // Replace the code
        return list1.toString().equals(this.toString());
    }

    public void clear() {
    	size = 0;
    }

    public static void main(String[] args) {
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
                    if (tokens.length == 2){
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));

                        }
                        else if (t.length == 2) {
                        	l.add(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
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
                        for(int i = 0; i < temp.length; i++) {
                            temp[i]=Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for(int i = 0; i < t2.length; i++)
                            a[i] = Integer.parseInt(t2[i]);
                        l.removeAll(a);
                    }
                break;
                case "subList": {
                    try {
                    	if (tokens.length != 2) break;
                    String[] arrstring3 = tokens[1].split(",");
                    Solution object = l.subList(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (object != null) 
                        System.out.println(object);
                } catch (Exception e) {
                        	System.out.println(e.getMessage());
                        }
                    break;
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        Solution l2 = new Solution();
                        for (int k = 0; k < lt.length; k++ ) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                case "count": {
                	if (tokens.length == 2) {
                        System.out.println(l.count(
                            Integer.parseInt(tokens[1])));
                    }
                }
                break;
                default:
                break;
            }
        }
    }
}
