import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * Functionality to find the answer of Friends pairing problem.
 *
 * <p>Provides functionality to find the total number of ways in which
 * friends can remain single or can be paired up.
 *
 * <p>User inputs int number of friends. Result is printed into console.
 * @author Taras Hlukhovetskyi
 */
public class FriendPairs implements Executable {
    private Scanner in;
    /**
     * Maximum friends quantity to algorithm run successfully due to int overflow.
     */
    private static final int MAX_FRIENDS = 17;

    /**
     * Constructor that sets Scanner.
     * @param in Scanner to get the input from
     */
    public FriendPairs(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        // input
        System.out.println("Enter number of friends to count ways of pairing them");
        int numberOfFriends;
        while (true) {
            numberOfFriends = in.nextInt();
            //If number is positive program continue execution
            if (numberOfFriends > 0) {
                break;
            }
            System.out.println("The number can not be negative. Enter once more:");
        }
        // answer output
        int answer = findWaysOfPairing(numberOfFriends);
        if (answer == -1) {
            System.out.println("Cant calculate because of int size restrictions");
        } else {
            System.out.println("Ways to pair: " + answer);
        }

    }

    /**
     * Find the total number of ways in which
     * friends can remain single or can be paired up.
     *
     * <p>Realisation is similar to Fibonacci algorithm. On each iteration we count our answer
     * to the current subtask using answers of previous subtasks until we get to the main
     * task answer.
     * @param numberOfFriends int number
     * @return int possible number of ways if successful, -1 if int overflow happens
     */
    public int findWaysOfPairing(int numberOfFriends) {
        int firstNumber = 1;
        int secondNumber = 2;
        int temp;
        // for number of friends less or equal 2 number of ways equals to numberOfFriends
        if (numberOfFriends <= 0) {
            throw new InvalidParameterException("Number of friends can't be negative!");
        }
        if (numberOfFriends <= 2) {
            return numberOfFriends;
        }
        if (numberOfFriends > MAX_FRIENDS){
            return -1;
        }

        for (int i = 3; i <= numberOfFriends; i++) {
            temp = (i - 1) * firstNumber + secondNumber;
            assert (temp > 0);
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        // answer of a subtask on the last iteration is the answer of our main task
        return secondNumber;
    }
}