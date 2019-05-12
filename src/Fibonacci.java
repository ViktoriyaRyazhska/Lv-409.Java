import java.security.InvalidParameterException;
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
        int answer = findFibonacciNumber(numberOfFib);
        if (answer == -1) {
            System.out.println("Cant calculate because of int size restrictions");
        } else {
            System.out.println(answer);
        }
    }


    /**
     * Finds fibonacci number up to 45th number.
     * @param numberOfFib sequence number for required Fibonacci number
     * @return int positive Fibonacci number when successful, -1 when int overflow
     */
    public int findFibonacciNumber(int numberOfFib) {

        int firstNumber = 1; // Fibonacci number on zero iteration
        int secondNumber = 1; // Fibonacci number on the first iteration

        //checking whether we have already counted number
        if (numberOfFib == 1) {
            return 1;
        }

        if (numberOfFib <= 0) {
            throw new InvalidParameterException("Sequence number can't be negative!");
        }

        int temp;
        for (int i = 2; i <= numberOfFib; i++) {
            temp = firstNumber + secondNumber;
            if (temp < 0) {
                return -1;
            }
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        // returning Fibonacci number on the last iteration
        return secondNumber;
    }
}
