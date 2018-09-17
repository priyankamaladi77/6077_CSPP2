import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
    	this.questiontext = question1;
    	this.choices = choices1;
    	this.correctAnswer = correctAnswer1;
    	this.maxMarks = maxMarks1;
    	this.penalty = penalty1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        if (choice.equals(choices[correctAnswer - 1])) {
        	return true;
        } else {
        	return false;
        }
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return this.correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
    	response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < choices.length - 1; i++) {
        	s += choices[i] + "\t";
        }
        return s + choices[choices.length - 1];
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
    	questions = new Question[onehundred];
    	size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
    	if (size == questions.length) {
    		resize();
    	}
    	if (size >= 0) {
    		questions[size] = q;
    		size += 1;
    	}
    }

    public void resize() {
    	questions = Arrays.copyOf(questions, size * 2);
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        int res = 0;
        if (size != 0) {
        	for (int i =0; i < size; i++) {
        		System.out.println(questions[i].getQuestionText());
        		if (questions[i].evaluateResponse(questions[i].getResponse())) {
        			System.out.println(" Correct Answer! - Marks Awarded: "
        				+ questions[i].getMaxMarks());
        			res = res + questions[i].getMaxMarks();
        		} else {
        			System.out.println(" Wrong Answer! - penalty: "
        				+ questions[i].getPenalty());
        			res = res + questions[i].getPenalty();
        		}
        	}
        	return "Total Score: " + res;
        } else {
        	return s;
        }
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int i;
        if (q == 0) {
        	System.out.println("Quiz does not have questions");
        	return;
        }
        for (i = 0; i < q; i++) {
        	String[] question = scan.nextLine().split(":");
        if (question.length < 2 + 2 + 1 || (question[0].length() == 0)) {
        	System.out.println("Error! Malformed question");
        	return;
        } else {
        if (question[1].split(",").length < 2) {
        	System.out.println(question[0] + " "
        		+ "does not have enough answer choices");
        	return;
        } else if (Integer.parseInt(question[2]) > 2 + 2) {
        	System.out.println("Error! Correct answer choice number is out of" + " "
        		+ "range for question text 1");
        	return;
        } else if (Integer.parseInt(question[2 + 1]) <= 0) {
        	System.out.println("Invalid max marks for" + " " + question[0]);
        	return;
        } else if (Integer.parseInt(question[2 + 2]) > 0) {
        	System.out.println("Invalid penalty for" + " " + question[0]);
        	return;
        }
    }
        String[] choices = question[1].split(",");
        Question quizz = new Question((question[0]), choices,
        	Integer.parseInt(question[2]), Integer.parseInt(question[2 + 1]),
        		Integer.parseInt(question[2 + 2]));
        quiz.addQuestion(quizz);
    }
    System.out.println(q + " are added to the quiz");
}
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        try {
        String solution;
        for (int i = 0; i < q; i++) {
        	System.out.println(quiz.getQuestion(i).getQuestionText()
        		+ "(" + quiz.getQuestion(i).getMaxMarks() + ")");
        	System.out.println(quiz.getQuestion(i).toString());
        	System.out.println();
        	solution = scan.nextLine();
        	quiz.getQuestion(i).setResponse(solution);
        }
        } catch (Exception e) {

        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        System.out.println(quiz.showReport());
    }
}
