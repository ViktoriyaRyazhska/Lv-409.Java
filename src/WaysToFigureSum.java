import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that calculates all possible ways to write n as sum of two or more positive integers.
 *
 * @author Olena Andrushchenko
 */

public class WaysToFigureSum implements Executable {


    /**
     * Constructs a new WaysToFigureSum using Scanner object.
     */
    public WaysToFigureSum() {
    }

    /**
     * Method inherited from Executable interface.
     * put together other methods
     *
     * @throws InputMismatchException if  in method input() returned value isn't a number.
     */
    @Override
    public void execute() throws InputMismatchException {
        int userNumber = input();
        output(waysToSum(userNumber));


    }

    /**
     * Method is scanning console to get number from user.
     *
     * @return number entered by user
     * @throws InputMismatchException if Scanner nextInt() returned value is not a number
     */
    public int input() throws InputMismatchException {
        System.out.println("Please enter the positive number to get all its possible partitions");
        Scanner in = new Scanner(System.in);
        while (true) {
            int userNumber = in.nextInt();
            if (userNumber >= 0) {


                return userNumber;
            }
            System.out.println("Sorry but Your number is not positive. Try again");
        }

    }

    /**
     * Prints the result of algorithm calculations.
     *
     * @param userNumber The number returned by input() method
     */
    public void output(int userNumber) {


        System.out.println("The number of partitions is: " + userNumber);

    }

    /**
     * Performs main calculations.
     * All variants are stored in an array.
     * If user's number is 0 - array is initialized with default value 1.
     * The loop iterates all integer one by one and update the count[] values
     * after the index greater than or equal to n
     *
     * @param param value entered by user and passed from output() method
     * @return maximum combinations of users's number partitions.
     */
    public int waysToSum(int param) {

        int[] count = new int[param + 1];

        count[0] = 1;

        for (int i = 1; i < param; i++) {
            for (int j = i; j <= param; j++) {
                count[j] += count[j - i];
            }
        }
        return count[param];
    }


}
