import java.util.InputMismatchException;
import java.util.Scanner;

public class InterestingRow implements Executable {

    /**
     * Main executing method inherited from Executable interface.
     */
    @Override
    public void execute() {

        int userNumber = input();
        System.out.println("Number at " + userNumber + " index "
                + "is " + findIntrestingRowMember(userNumber));

    }

    /**
     * Scanning console to get users number.
     *
     * @return user's number
     */
    public int input() throws InputMismatchException {

        System.out.println("Please enter index to get the number in array");
        Scanner in = new Scanner(System.in);

        while (true) {

            int inputNumber = in.nextInt();
            if (inputNumber >= 0) {
                return inputNumber;
            }
            System.out.println("Sorry but Your number is not positive. Try again");
        }


    }


    /**
     * Make up an array with lengths userNumber+2.
     *
     * @param userNumber is number entered by user
     * @return number in array at position userNumber
     */
    public int findIntrestingRowMember(int userNumber) {

        if (userNumber < 1) {
            return 0;
        }

        int[] interestingRowArray = new int[userNumber + 2];
        interestingRowArray[1] = 1;
        interestingRowArray[2] = 1;
        for (int i = 3; i <= userNumber; i++) {
            interestingRowArray[i] = 2 * interestingRowArray[i - 2] + interestingRowArray[i - 1];
        }
        return interestingRowArray[userNumber];
    }

}
