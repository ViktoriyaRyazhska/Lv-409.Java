import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for counting the number of ways to
 * sum N using array elements with repetition.
 *
 * @author Andrii Vashchenok
 */
public class WaysToSum implements Executable {

    private int digitNum;
    private int[] array;
    private Scanner scanner;

    /**
     * Constructor for class WaysToSum.
     *
     * @param scanner Scanner for input in the class.
     */
    public WaysToSum(Scanner scanner) {

        this.scanner = scanner;

    }

    /**
     * Main method for executing class calculations.
     *
     * @throws InputMismatchException Exception can be thrown from inner method call input().
     */
    @Override
    public void execute() throws InputMismatchException {

        int[] count = new int[digitNum + 1];

        input();

        // base case
        count[0] = 1;

        // count ways for all values up
        // to 'digitNum' and store the result
        for (int i = 1; i <= digitNum; i++) {
            for (int j = 0; j < array.length; j++) {

                // if i >= arr[j] then
                // accumulate count for value 'i' as
                // ways to form value 'i-arr[j]'
                if (i >= array[j]) {
                    count[i] += count[i - array[j]];
                }
            }
        }

        output(count[digitNum]);

    }

    /**
     * Method for printing execution result.
     *
     * @param num Number of ways (result of the execution).
     */
    public void output(int num) {

        // required number of ways
        System.out.println("Required number of ways: " + num);

    }

    /**
     * Method for getting input from user: number to be summed up,
     * array of digits number to be summed with.
     *
     * @throws InputMismatchException Exception can be thrown in case not numeric input.
     */
    public void input() throws InputMismatchException {

        System.out.println("Enter number to be summed up: ");

        while (true) {
            digitNum = scanner.nextInt(); //If number is positive program continue execution
            if (digitNum > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }

        System.out.println("Enter number of digits in array: ");
        int num;
        while (true) {
            num = scanner.nextInt();
            if (num > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }

        array = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter next digit: ");
            array[i] = scanner.nextInt();
        }

    }

}
