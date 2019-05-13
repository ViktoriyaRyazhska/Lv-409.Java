import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for calculation non-crossing lines to connect points in a circle.
 *
 * @author Andrii Vashchenok
 */
public class PathWithoutCrossing implements Executable {

    /**
     * Main method for getting input, calculating and output of result.
     */
    @Override
    public void execute() {

        int calcArg = input();
        System.out.println("Number of crossing paths: " + calculate(calcArg));

    }

    /**
     * Method for getting input from user: the number of points in the circle.
     *
     * @return Int - the number of points in the circle.
     */
    public int input() {
        Scanner scanner = new Scanner(System.in);
        int pointNum;
        System.out.println("Enter the number of points in the circle: ");
        String line;
        while (true) {
            try {
                line = scanner.nextLine();
                pointNum = Integer.parseInt(line);
                if (pointNum > 1) { //If number is positive program continue execution
                    break;
                }
            } catch (NumberFormatException e) {
                // Continue loop
            }
            System.out.println("Incorrect number (number must be more than 1. Enter once more:");
        }

        return pointNum;
    }

    /**
     * Method for calculating the number of ways.
     *
     * @param innerPointNum The number of points divided by 2.
     * @return The number of ways to connect point without crossing (last entry).
     */
    int calculate(int innerPointNum) {

        innerPointNum = innerPointNum / 2;

        if (innerPointNum < 2) {
            return 0;
        }

        int []subproblemRes = new int [innerPointNum + 1];

        subproblemRes[0] = subproblemRes[1] = 1;

        for (int i = 2; i <= innerPointNum; i++) {
            subproblemRes[i] = 0;
            for (int j = 0; j < i; j++) {
                subproblemRes[i] += subproblemRes[j] * subproblemRes[i - j - 1];
            }
        }

        return subproblemRes[innerPointNum];

    }

}
