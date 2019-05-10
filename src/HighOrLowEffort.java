import java.util.InputMismatchException;
import java.util.Scanner;

public class HighOrLowEffort implements Executable {
    private Scanner in;
    private int numberOfDays;
    private int[] lowEffortArray;
    private int[] highEffortArray;

    public HighOrLowEffort(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() throws InputMismatchException {
        input();
        System.out.println("The maximum amount of cost you can perform within these"
            + numberOfDays + "days is: " + findMaxAmountOfCost());
    }

    private void input() throws InputMismatchException {
        System.out.println("Enter number of days:");
        while (true) {
            numberOfDays = in.nextInt();
            //If number is positive program continue execution
            if (numberOfDays > 0) {
                break;
            }
            System.out.println("Number of days can not be negative. Enter once more:");
        }
        System.out.println("Enter low effort tasks:");
        lowEffortArray = fillEffortArray();
        System.out.println("Enter high effort tasks:");
        highEffortArray = fillEffortArray();
    }

    private int[] fillEffortArray() throws InputMismatchException {
        int[] array = new int[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    private int findMaxAmountOfCost() {
        // start from second day, because we will always take high for a first day
        int maxAmountOfCost = highEffortArray[0];
        int lastDayAmount = highEffortArray[0];
        // find maximum amount of cost
        for (int i = 1; i < numberOfDays; i++) {
            if (lastDayAmount == 0) {
                maxAmountOfCost += highEffortArray[i];
                lastDayAmount = highEffortArray[i];
            } else {
                maxAmountOfCost += lowEffortArray[i];
                lastDayAmount = lowEffortArray[i];
            }
        }
        return maxAmountOfCost;
    }
}
