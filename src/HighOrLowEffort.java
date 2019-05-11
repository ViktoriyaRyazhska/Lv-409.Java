import java.util.InputMismatchException;
import java.util.Scanner;

public class HighOrLowEffort implements Executable {
    private Scanner in;

    public HighOrLowEffort(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() throws InputMismatchException {
        int numberOfDays = inputNumberOfDays();
        System.out.println("Enter low effort tasks:");
        int[] lowEffortTasks = fillEffortArray(numberOfDays);
        System.out.println("Enter high effort tasks:");
        int[] highEffortTasks = fillEffortArray(numberOfDays);
        output(numberOfDays, findMaxAmountOfCost(numberOfDays, lowEffortTasks, highEffortTasks));
    }

    private int inputNumberOfDays() throws InputMismatchException {
        System.out.println("Enter number of days:");
        int numberOfDays;
        while (true) {
            numberOfDays = in.nextInt();
            //If number is positive program continue execution
            if (numberOfDays > 0) {
                break;
            }
            System.out.println("Number of days can not be negative. Enter once more:");
        }
        return numberOfDays;
    }

    private void output(int numberOfDays, int maxAmountOfCost) {
        System.out.println("The maximum amount of cost you can perform within these"
            + numberOfDays + "days is: " + maxAmountOfCost);
    }

    private int[] fillEffortArray(int numberOfDays) throws InputMismatchException {
        int[] array = new int[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

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
