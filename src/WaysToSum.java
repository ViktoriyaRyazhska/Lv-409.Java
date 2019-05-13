import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for counting the number of ways to
 * sum N using array elements with repetition.
 *
 * @author Andrii Vashchenok
 */
public class WaysToSum implements Executable {

    /**
     * Main method for getting input, calculation and outputing.
     */
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        int digit;
        System.out.println("Enter number to be summed up: ");
        String inputtedLine;
        while (true) {
            try {
                inputtedLine = scanner.nextLine();
                digit = Integer.parseInt(inputtedLine);
                if (digit > 0) { //If number is positive program continue execution
                    break;
                }
            } catch (NumberFormatException e) {
                // Continue loop
            }
            System.out.println("Incorrect. Enter once more:");
        }

        System.out.println("Required number of ways: " + calculate(digit, input(scanner)));

    }

    /**
     * Method for getting input from user:
     * array of digits number to be summed with.
     *
     * @return Integer array.
     */
    public int[] input(Scanner scanner) {

        System.out.println("Input array of integers ( e.g.: 3 2 1 4 0 ):");

        String inputtedLine = scanner.nextLine();
        String[] inputtedWords = inputtedLine.split(" ");

        int[] array = new int[inputtedWords.length];

        try {

            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(inputtedWords[i]);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Try again. ");
            array = input(scanner);
        }

        return array;

    }

    /**
     * Method for calculation the number of ways to sum
     * digit.
     *
     * @param digitNum Digit which is summed up.
     * @param array Array of integers which sum up digit.
     * @return Integer - number of ways to sum up chosen digit.
     */
    int calculate(int digitNum, int[] array) {

        if (digitNum < 1) {
            return 0;
        }
        for (int i : array) {
            if (i < 1) {
                return 0;
            }
        }

        int[] count = new int[digitNum + 1];

        count[0] = 1;

        for (int i = 1; i <= digitNum; i++) {
            for (int j = 0; j < array.length; j++) {

                if (i >= array[j]) {
                    count[i] += count[i - array[j]];
                }

            }
        }

        return count[digitNum];

    }

}
