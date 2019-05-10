import java.util.InputMismatchException;
import java.util.Scanner;

public class PathWithoutCrossing implements Executable {

    // The number of points in the circle
    private int N;
    private Scanner scanner;

    public PathWithoutCrossing(Scanner scanner) {

        this.scanner = scanner;

    }

    @Override
    public void execute() throws InputMismatchException {

        input();

        // Throw error if n is odd
        if (N < 1)
        {
            System.err.println("Error: N has to be 1 or more.");
            return;
        }

        // Else return n/2'th
        // Catalan number
        output();

    }

    public void input() throws InputMismatchException {

        System.out.println("Enter the number of points in the circle: ");
        while (true) {
            N = scanner.nextInt();            //If number is positive program continue execution
            if (N > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }


    }

    public void output() {

        System.out.println("Number of crossing paths: " + catalanDP(N / 2));

    }

    private int catalanDP(int n) {

        // Table to store
        // results of subproblems
        int []catalan = new int [n + 1];

        // Initialize first
        // two values in table
        catalan[0] = catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++)
        {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] *
                        catalan[i - j - 1];
        }

        // Return last entry
        return catalan[n];

    }

}
