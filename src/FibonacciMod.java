import java.util.Scanner;

public class FibonacciMod implements Executable {
    private Scanner in;

    FibonacciMod(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        int numberOfFib = input();
        int foundNumber = findFibNumber(numberOfFib);
        System.out.println("The " + numberOfFib + " modification fibonacci number is "
            + foundNumber);
    }

    private int input() {
        System.out.println("Enter number of fibonacci number:");
        while (true) {
            int numberOfFib = in.nextInt();
            //If number is positive program continue execution
            if (numberOfFib > 0) {
                return numberOfFib;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }
    }

    public int findFibNumber(int numberOfFib) {
        //If number is first - third number, wanted fibonacci number is 1
        if (numberOfFib == 1 || numberOfFib == 2 || numberOfFib == 3) {
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

