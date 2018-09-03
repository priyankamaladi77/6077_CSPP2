import java.util.Scanner;
/**
 * @author     : priyanka maladi
 *
 * Class for student details.
 */
public class StudentDetails {
    /**
     * { var_description }.
     */
     private static final int THREE = 3;
      /**
       *@param      args .
     * { var_description }.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String studentname = s.nextLine();
        String rollnumber = s.nextLine();
        double marks1 = s.nextDouble();
        double marks2 = s.nextDouble();
        double marks3 = s.nextDouble();
        Student stu = new Student(studentname, rollnumber, m1, m2, m3);
        System.out.println(stu.Average());
    }
}
/**
 * Class for student.
 */
class Student {
    /**
 * Class for student.
 */
    private String studentname;
    /**
 * Class for student.
 */
    private String rollnumber;
    /**
 * Class for student.
 */
    private double marks1;
    /**
 * Class for student.
 */
    private double marks2;
    /**
 * Class for student.
 */
    private double marks3;

    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      roll    The roll
     * @param      marks1  The marks 1
     * @param      marks2  The marks 2
     * @param      marks3  The marks 3
     */
    public Student(final String name, final String roll, final double marks1,
        final double marks2, final double marks3) {
        studentname = name;
        rollnumber = roll;
        this.mar1 = mar1;
        this.mar2 = mar2;
        this.mar3 = mar3;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public double average() {
        double avg = (this.m1 + this.m2 + this.m3) / THREE;
        return avg;
    }
}
