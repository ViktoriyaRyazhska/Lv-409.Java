import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for calculating result of painting fence problem.
 * using one variable instead of a table to optimize.
 *
 * @author Volodymyr Oseredchuk
 */
public class OptimizedPaintingFence implements Executable {
    private Scanner in;
    private int postsCount;
    private int colorsCount;

    /**
     * Constructor for class OptimizedPaintingFence.
     *
     * @param sc Scanner scanner object for console input
     */
    public OptimizedPaintingFence(Scanner sc) {
        this.in = sc;
    }

    /**
     * Method for executing algorithm - includes input and output.
     *
     * @throws InputMismatchException if input types are not compatible with int
     */
    @Override
    public void execute() throws InputMismatchException {
        input();
        System.out.println(countWaysToColor(postsCount, colorsCount));
    }

    /**
     * Method for getting posts and colors count from user.
     *
     * @throws InputMismatchException if input type is not compatible with int
     */
    public void input() throws InputMismatchException {
        // input posts and colors count
        while (true) {
            System.out.println("Enter number of posts:");
            postsCount = in.nextInt();
            System.out.println("Enter number of colors:");
            colorsCount = in.nextInt();
            // if valid input - breaks from loop and continue execution
            if ((postsCount > 0) && (colorsCount > 0)) {
                break;
            }
            System.out.println("Posts and colors quantity should be positive. Try again:");
        }
    }

    /**
     * Method for counting ways to paint the fence
     * using optimized painting fence algorithm.
     *
     * @param postsCount  int quantity of posts that needs to be painted
     * @param colorsCount int quantity of different colors
     * @return waysToColor long quantity of ways to paint the fence
     */
    public long countWaysToColor(int postsCount, int colorsCount) {
        /*
         * Rule: at most 2 adjacent posts have the same color.
         */
        if ((postsCount < 1) || (colorsCount < 1)) {
            return 0;
        }
        // there are colorsCount ways to color the first post
        long waysToColor = colorsCount;
        /*
         * there are 0 ways for single post to violate the rule - same color
         * and colorsCount ways to not violate - different color
         */
        long same = 0;
        long different = colorsCount;
        // coloring the rest of the fence
        for (int i = 2; i <= postsCount; i++) {
            // 'different' value for previous post equals 'same' value for current post
            same = different;
            // we always have (colorsCount - 1) ways to color the next post
            different = waysToColor * (colorsCount - 1);
            assert (different > 0);
            // ways to color the fence that consists of (i) posts
            waysToColor = same + different;
            assert (waysToColor > 0);
        }
        return waysToColor;
    }
}
