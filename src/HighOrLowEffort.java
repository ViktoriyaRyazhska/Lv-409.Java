import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for finding the maximum amount of cost you can perform within
 * these n days with high- and low-effort tasks.
 *
 * @author Danylo Lototskyi
 */
public class HighOrLowEffort implements Executable {
    private Scanner scanner;

    /**
     * Constructor for class HighOrLowEffort.
     *
     * @param scanner Scanner for input in the class.
     */
    public HighOrLowEffort(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Main method for getting input and output.
     *
     * @throws InputMismatchException if user enter not integer value in input().
     */
    @Override
    public void execute() throws InputMismatchException {
        int numberOfDays = inputNumberOfDays();
        System.out.println("Enter low effort tasks:");
        int[] lowEffortTasks = fillEffortArray(numberOfDays);
        System.out.println("Enter high effort tasks:");
        int[] highEffortTasks = fillEffortArray(numberOfDays);
        output(numberOfDays, findMaxAmountOfCost(numberOfDays, lowEffortTasks, highEffortTasks));
    }

    /**
     * Method for getting input of number of days.
     *
     * @return number of days to perform tasks.
     * @throws InputMismatchException if user enters not integer value.
     */
    private int inputNumberOfDays() throws InputMismatchException {
        System.out.println("Enter number of days:");
        int numberOfDays;
        while (true) {
            numberOfDays = scanner.nextInt();
            //If number is positive program continue execution
            if (numberOfDays > 0) {
                break;
            }
            System.out.println("Number of days can not be negative. Enter once more:");
        }
        return numberOfDays;
    }

    /**
     * Method for printing execution result.
     *
     * @param numberOfDays number of days to perform tasks.
     * @param maxAmountOfCost maximum amount of cost that can be performed within numberOfDays days.
     */
    private void output(int numberOfDays, int maxAmountOfCost) {
        System.out.println("The maximum amount of cost you can perform within these"
            + numberOfDays + "days is: " + maxAmountOfCost);
    }

    /**
     * Method for getting input of array of costs.
     *
     * @param numberOfDays number of days to perform tasks.
     * @return array filled with costs of tasks.
     * @throws InputMismatchException if user enters not integer value.
     */
    private int[] fillEffortArray(int numberOfDays) throws InputMismatchException {
        int[] array = new int[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    /**
     * Method for calculating maximum amount of cost that can be performed
     * within numberOfDays days.
     *
     * @param numberOfDays number of days to perform tasks.
     * @param lowEffortTasks array of costs of low-effort tasks.
     * @param highEffortTasks array of costs of high-effort tasks.
     * @return maximum amount of cost that can be performed within numberOfDays days.
     */
    public int findMaxAmountOfCost(int numberOfDays, int[] lowEffortTasks, int[] highEffortTasks) {
        // start from second day, because we will always take high for a first day
        int maxAmountOfCost = highEffortTasks[0];
        int lastDayAmount = highEffortTasks[0];
        // find maximum amount of cost
        for (int i = 1; i < numberOfDays; i++) {
            if (lastDayAmount == 0) {
                maxAmountOfCost += highEffortTasks[i];
                lastDayAmount = highEffortTasks[i];
            } else {
                maxAmountOfCost += lowEffortTasks[i];
                lastDayAmount = lowEffortTasks[i];
            }
        }
        return maxAmountOfCost;
    }
}
