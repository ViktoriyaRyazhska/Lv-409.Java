import java.util.InputMismatchException;
import java.util.Scanner;

public class WaysToSum implements Executable{

    private int N;
    private int[] array;
    private Scanner scanner;

    public WaysToSum(Scanner scanner) {

        this.scanner = scanner;

    }

    @Override
    public void execute() throws InputMismatchException {

        input();

        int count[] = new int[N + 1];

        // base case
        count[0] = 1;

        // count ways for all values up
        // to 'N' and store the result
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < array.length; j++)

                // if i >= arr[j] then
                // accumulate count for value 'i' as
                // ways to form value 'i-arr[j]'
                if (i >= array[j]) {
                    count[i] += count[i - array[j]];
                }
        }

        output(count[N]);

    }

    public void output(int num) {

        // required number of ways
        System.out.println("Required number of ways: " + num);

    }

    public void input() throws InputMismatchException {

        System.out.println("Enter number to be summed up: ");

        while (true) {
            N = scanner.nextInt();            //If number is positive program continue execution
            if (N > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }

        System.out.println("Enter number of digits in array: ");
        int num;
        while (true) {
            num = scanner.nextInt();
            if (num > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }

        array = new int[num];
        for(int i = 0; i < num; i++) {
            System.out.println("Enter next digit: ");
            array[i] = scanner.nextInt();
        }

    }

}
