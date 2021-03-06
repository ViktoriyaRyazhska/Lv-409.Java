import java.util.Scanner;

/**
 * We can calculate our possibility to cover the distance with 1, 2 and 3 steps.
 * 
 * @author Rostyslav Hlynka
 */

public class WaysToCoverInThreeSteps implements Executable {

    /**
     * Runs the task's implementation.
     */
    @Override
    public void execute() {
        
        int distance = initDistance();
        int ways = countWays(distance);
        System.out.println(ways);
    }

    /**
     * Count total number of ways to cover the distance with 1, 2 and 3 steps.
     * 
     * @param n given distance
     * @return amount of ways to cover the distance with 1, 2 and 3 steps
     */
    public int countWays(int n) {

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    /**
     * Initialize array that need to be sorted.
     * 
     * @return array that need to be sorted
     */
    private int initDistance() {

        System.out.println("Input the distance, int (bigger than 2):");
        Scanner sc = new Scanner(System.in);
        
        int distance;

        while (true) {

            distance = sc.nextInt();

            if (distance > 2) {
                break;
            }
            System.out.println("Invalid input! int should be bigger than 2. Try again!");
        }

        return distance;

    }

}
