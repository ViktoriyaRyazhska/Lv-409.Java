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
        System.out.println("Ways to pair: " + findWaysOfPairing(numberOfFriends));
    }

    /**
     * Find the total number of ways in which
     * friends can remain single or can be paired up.
     *
     * <p>Realisation is similar to Fibonacci algorithm. On each iteration we count our answer
     * to the current subtask using answers of previous subtasks until we get to the main
     * task answer.
     * @param numberOfFriends int number
     * @return int possible number of ways
     */
    public int findWaysOfPairing(int numberOfFriends) {
        // for number of friends less or equal 2 number of ways equals to numberOfFriends
        if (numberOfFriends <= 2) {
            return numberOfFriends;
        }
        int firstNumber = 1;
        int secondNumber = 2;
        int temp;

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