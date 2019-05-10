import java.util.Scanner;

public class Fibonacci implements Executable {
    private Scanner in;

    public Fibonacci(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        //input
        System.out.println("Enter number of fibonacci :");
        int numberOfFib;
        while (true) {
            numberOfFib = in.nextInt();
            //If number is positive program continue execution
            if (numberOfFib > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }
        //answer output
        System.out.println(findFibNumber(numberOfFib));
    }


    private int findFibNumber(int numberOfFib) {
        //checking whether we have already counted number
        if (numberOfFib == 1) {
            return 1;
        }

        int firstNumber = 1; // Fibonacci number on zero iteration
        int secondNumber = 1; // Fibonacci number on the first iteration

        int temp;
        for (int i = 2; i <= numberOfFib; i++) {
            temp = firstNumber + secondNumber;
            assert (temp > 0); // for int overflow
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        // returning Fibonacci number on the last iteration
        return secondNumber;
    }
}
