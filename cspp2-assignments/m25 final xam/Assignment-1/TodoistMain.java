import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private boolean important;
	private  boolean urgent;
	private String status;

	Task(final String tle, final String assignTo, final int tmeToComplete,
		final boolean imp, final boolean ugent, final String statu) {
		this.title = tle;
		this.assignedTo = assignTo;
		this.timeToComplete = tmeToComplete;
		this.important = imp;
		this.urgent = ugent;
		this.status = statu;
		if (title == "") {
    		System.out.println("Title not provided");
    	if (timeToComplete < 0) {
    		System.out.println("Invalid timeToComplete" + " " + timeToComplete);
    	}
    	if (status != "todo" && status != "done") {
    		System.out.println("Invalid status" + " " + status);
    	}
    }
	}

	public String toString() {
		String str = "";
		str += title + ", " + assignedTo + ", " + timeToComplete + ", " + important + ", " + urgent + ", " + status;
		return str;
	}

}

class Todoist {
 	private Task[] tasks;

 	Todoist(final Task[] task) {
 		this.tasks = task;
 	}

 	public void Add(final Task createTask) {

 	}

}
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void main(final String[] args) {
        //Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    //testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    //System.out.println(todo);
                break;
                case "get-next":
                    //System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    //Task[] tasks = todo.getNextTask(tokens[1], n);
                    //System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    //System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            //todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
    	if (tokens[1] == "") {
    		System.out.println("Title not provided");
    	if (Integer.parseInt(tokens[3]) < 0) {
    		System.out.println("Invalid timeToComplete" + " " + Integer.parseInt(tokens[3]));
    	}
    	if (tokens[6] != "todo" && tokens[6] != "done") {
    		System.out.println("Invalid status" + " " + tokens[6]);
    	}
    	}
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    // public static void main(final String[] args) {
    //     startTest();
    // }
}
