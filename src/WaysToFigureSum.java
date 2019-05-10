import java.util.InputMismatchException;
import java.util.Scanner;

//Task that calculates all possible ways to write n as sum of two or more positive integers
public class WaysToFigureSum implements Executable {

    private Scanner in;

    public WaysToFigureSum(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() throws InputMismatchException {
        System.out.println("Please enter the positive number to get all its possible partitions");
        while (true) {
            int userNumber = in.nextInt();
            if (userNumber >= 0) {

                System.out.println("The number of partitions is: " + countWays(userNumber));
                break;
            }
            System.out.println("Sorry but Your number is not positive. Try again");
        }


    }


    //method, responsible for calculations
    public int countWays(int givenNumber) {

        // arrays that stores all possible variants
        int count[] = new int[givenNumber + 1];

        // default value - if given number is 0
        count[0] = 1;

        // Iterate all integer one by one and update the count[] values after the index greater than or equal to n
        for (int i = 1; i < givenNumber; i++) {
            for (int j = i; j <= givenNumber; j++) {
                count[j] += count[j - i];
            }
        }
        return count[givenNumber];
    }
}
