import java.util.Scanner;

/**
 * Class for calculation non-crossing lines to connect points in a circle.
 *
 * @author Olha Lozinska
 */

public class LongestSubsequence implements Executable {
    private Scanner scan;

    /**
     * Constructor for class PathWithoutCrossing.
     *
     * @param scan Scanner for input in the class.
     */

    public LongestSubsequence(Scanner scan) {
        this.scan = scan;
    }

    /**
     * Main method for getting input, calculating and output of result.
     */
    @Override
    public void execute() {
        int[] inputArray = inputValues();
        int result = output(inputArray);
        System.out.println("Maximal length of subsequence: " + result);
    }
    /**
     * Method for getting input from user: the array of numbers.
     *
     * @return int[] - the array of numbers.
     */
    private int[] inputValues() {
        int arrayLength;
        System.out.println("Enter number of elements in array:");

        while (true) {
            arrayLength = scan.nextInt();
            if (arrayLength > 0) {
                break;
            }
            System.out.println("The array length should be positive. Enter once more:");
        }
        int[] setOfNumbers = new int[arrayLength];
        System.out.println("Enter " + arrayLength + " integer elements of the array:");
        for (int i = 0; i < arrayLength; i++) {
            setOfNumbers[i] = scan.nextInt();
        }
        return setOfNumbers;
    }
    /**
     * Method for printing execution result.
     *
     * @param setOfNumbers the array of numbers.
     */
    private int output(int[] setOfNumbers) {
        int counter = 1;
        int maxSequenceLength = 1;
        for (int i = 0; i < setOfNumbers.length - 1; i++) {
            if ((setOfNumbers[i + 1] - setOfNumbers[i]) == 1) {
                counter++;
                if (maxSequenceLength < counter) {
                    maxSequenceLength = counter;
                }
            } else {
                counter = 1;
            }

        }
        return maxSequenceLength;
    }
}