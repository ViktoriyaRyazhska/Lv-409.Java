import java.util.InputMismatchException;
import java.util.Scanner;


public class FibonacciMod implements Executable {
    private Scanner in;

    public FibonacciMod(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() throws InputMismatchException {
        int numberOfFib = input();
        output(findFibNumber(numberOfFib));
    }

    private int input() throws InputMismatchException {
        System.out.println("Enter number of fibonacci number:");
        int numberOfFib;
        while (true) {
            numberOfFib = in.nextInt();
            //If number is positive program continues execution
            if (numberOfFib > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }
        return numberOfFib;
    }

    private void output(int numberOfFib) {
        System.out.println("The modification fibonacci number is: "
            + numberOfFib);
    }

    public int findFibNumber(int numberOfFib) {
        //If number is first - third number, wanted fibonacci number is 1
        if (numberOfFib <= 3) {
            return 1;
        }
        int firstNumber = 1;
        int secondNumber = 1;
        int thirdNumber = 1;
        int temp;
        //Find number that is under numberOfFib
        for (int i = 3; i < numberOfFib; i++) {
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

