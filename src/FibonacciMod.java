import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for finding which is the member of some position in Modification Fibonacci sequence.
 *
 * @author Danylo Lototskyi
 */
public class FibonacciMod implements Executable {

    /**
     * Main method for getting input and output.
     *
     * @throws InputMismatchException if user enter not integer value in input().
     */
    @Override
    public void execute() throws InputMismatchException {
        int numberToFindFib = input();
        System.out.println("The modification fibonacci number is: "
            + findFibNumber(numberToFindFib));
    }

    /**
     * Method for getting input of number of position in
     * Modification Fibonacci sequence.
     *
     * @return number of position in Modification Fibonacci sequence.
     * @throws InputMismatchException if user enters not integer value.
     */
    private int input() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of modification fibonacci number:");
        int numberToFindFib;
        while (true) {
            numberToFindFib = scanner.nextInt();
            //If number is positive program continues execution
            if (numberToFindFib > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }
        return numberToFindFib;
    }

    /**
     * Method for finding number from Modification Fibonacci sequence under the given number.
     *
     * @param numberToFindFib number of position in Modification Fibonacci sequence.
     * @return number from Modification Fibonacci sequence under numberToFindFib.
     */
    public int findFibNumber(int numberToFindFib) {
        //If number is first - third number, wanted fibonacci number is 1
        if (numberToFindFib <= 3) {
            return 1;
        }
        int firstNumber = 1;
        int secondNumber = 1;
        int thirdNumber = 1;
        int temp;
        //Find number that is under numberOfFib
        for (int i = 3; i < numberToFindFib; i++) {
            temp = firstNumber + thirdNumber;
            assert (temp > 0);
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            thirdNumber = temp;
        }
        //Return third number that is fibonacci number wanted
        return thirdNumber;
    }
}

