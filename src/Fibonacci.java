import java.util.Scanner;

/**
 * Functionality to find the Fibonacci number.
 *
 * <p>Provides functionality to find the the Fibonacci number by its sequence number
 * that is written by a user in console
 * @author Taras Hlukhovetskyi
 */
public class Fibonacci implements Executable {
    private Scanner in;

    /**
     * Constructor that sets Scanner.
     * @param in Scanner to get the input from
     */
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
        System.out.println(findFibonacciNumber(numberOfFib));
    }


    /**
     * Finds fibonacci number.
     * @param numberOfFib sequence number for required Fibonacci number
     * @return int Fibonacci number
     */
    public int findFibonacciNumber(int numberOfFib) {
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
