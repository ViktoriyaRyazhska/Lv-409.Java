import java.util.Scanner;

public class OptimizedPaintingFence implements Executable {
    private Scanner in;
    private int postsCount;
    private int colorsCount;

    public OptimizedPaintingFence(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        input();
        System.out.println(countWaysToColor());
    }

    private void input() {
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

    /*
        Rule: at most 2 adjacent posts have the same color.
     */
    private long countWaysToColor() {
        long waysToColor;
        // there are colorsCount ways to color the first post
        waysToColor = colorsCount;
        /*
            there are 0 ways for single post to violate the rule - same color
            and colorsCount ways to not violate - different color
         */
        long same;
        long different;
        same = 0;
        different = colorsCount;
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
