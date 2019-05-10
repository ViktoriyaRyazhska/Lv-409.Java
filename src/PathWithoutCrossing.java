import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for calculation non-crossing lines to connect points in a circle.
 *
 * @author Andrii Vashchenok
 */
public class PathWithoutCrossing implements Executable {

    // The number of points in the circle
    private int pointNum;
    private Scanner scanner;

    /**
     * Constructor for class PathWithoutCrossing.
     *
     * @param scanner Scanner for input in the class.
     */
    public PathWithoutCrossing(Scanner scanner) {

        this.scanner = scanner;

    }

    /**
     * Main method for executing class calculations.
     *
     * @throws InputMismatchException Exception can be thrown from inner method call input().
     */
    @Override
    public void execute() throws InputMismatchException {

        input();

        // Throw error if n is odd
        if (pointNum < 1) {
            System.err.println("Error: pointNum has to be 1 or more.");
            return;
        }

        // Else return n/2'th
        // Catalan number
        output();

    }

    /**
     * Method for getting input from user: the number of points in the circle.
     *
     * @throws InputMismatchException Exception can be thrown in case not numeric input.
     */
    public void input() throws InputMismatchException {

        System.out.println("Enter the number of points in the circle: ");
        while (true) {
            pointNum = scanner.nextInt();  //If number is positive program continue execution
            if (pointNum > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }


    }

    /**
     * Method for printing execution result.
     */
    public void output() {

        System.out.println("Number of crossing paths: " + catalanDP(pointNum / 2));

    }

    /**
     * Method for calculating the number of ways.
     *
     * @param innerPointNum The number of points divided by 2.
     * @return The number of ways to connect point without crossing.
     */
    private int catalanDP(int innerPointNum) {

        // Table to store
        // results of subproblems
        int []catalan = new int [innerPointNum + 1];

        // Initialize first
        // two values in table
        catalan[0] = catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= innerPointNum; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        // Return last entry
        return catalan[innerPointNum];

    }

}
