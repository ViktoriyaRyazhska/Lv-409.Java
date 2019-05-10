import java.util.Scanner;

public class FriendPairs implements Executable {
    private Scanner in;

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
        System.out.println("Ways to pair: " + countWaysOfPairing(numberOfFriends));
    }


    private int countWaysOfPairing(int numberOfFriends) {
        // for number of friends less or equal 2 number of ways equals to numberOfFriends
        if (numberOfFriends <= 2) {
            return numberOfFriends;
        }
        int firstNumber = 1; // ways to pair when there is only one friend
        int secondNumber = 2; // ways to pair when there is two friends
        int temp;
        // on each iteration we count our answer to the current subtask using
        // answers of previous subtasks until we get to the main task answer
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