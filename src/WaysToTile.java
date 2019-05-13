import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for counting the number of ways to
 * tile the floor with given size.
 *
 * @author Andrii Vashchenok
 */
public class WaysToTile implements Executable {

    private int verticalN;
    private int horizontalN;

    /**
     * Method for getting input from user:
     * size of the floor (N x M).
     *
     * @throws InputMismatchException Is thrown when method gets incorrect input.
     */
    public void input() throws InputMismatchException {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter vertical number of tiles:");
            verticalN = in.nextInt();
            System.out.println("Enter horizontal number of tiles:");
            horizontalN = in.nextInt();
            // if valid input - breaks from loop and continue execution
            if ((verticalN > 0) && (horizontalN > 0)) {
                break;
            }
            System.out.println("Vertical and horizontal quantity of tiles should be positive. "
                + "Try again:");
        }

    }

    /**
     * Main method for getting input, calculation and outputing.
     */
    @Override
    public void execute() {
        input();

        int result = countNumberOfWays(verticalN, horizontalN);

        System.out.println("Number of ways to tile the floor: " + result);
    }

    /**
     * Method for calculation the number of ways
     * to tile the floor.
     *
     * @param n Count if vertical tiles.
     * @param m Count of horizontal.
     * @return Number of ways to tile the floor.
     */
    public int countNumberOfWays(int n, int m) throws InvalidParameterException {
        if (n < 1 || m < 2) {
            throw new InvalidParameterException();
        }

        int[] count = new int[n + 1];
        count[0] = 0;
        int i;
        for (i = 1; i <= n; i++) {
            if (i > m) {
                count[i] = count[i - 1] + count[i - m];
            } else if (i < m) {
                count[i] = 1;
            } else {
                count[i] = 2;
            }
        }

        return count[n];

    }
}
