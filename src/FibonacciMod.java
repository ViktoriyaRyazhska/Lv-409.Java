import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciMod implements Executable {
    private Scanner in;
    private int numberOfFib;

    public FibonacciMod(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() throws InputMismatchException {
        input();
        System.out.println("The " + numberOfFib + " modification fibonacci number is " + findFibNumber());
    }

    private void input() throws InputMismatchException{
        System.out.println("Enter number of fibonacci number:");
        while (true) {
            numberOfFib = in.nextInt();
            //If number is positive program continue execution
            if (numberOfFib > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }
    }

    private int findFibNumber(){
        //If number is first - third number, wanted fibonacci number is 1
        if (numberOfFib == 1 || numberOfFib == 2 || numberOfFib == 3) {
            return 1;
        }
        int firstNumber;
        firstNumber = 1;
        int secondNumber;
        secondNumber = 1;
        int thirdNumber;
        thirdNumber = 1;
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

