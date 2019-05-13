import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that calculates all possible combinations of given users numbers.
 *
 * @author Olena Andrushchenko
 */
public class PaintingFence implements Executable {

    /**
     * Constructs new PaintingFence object using specified Scanner.
     */
    public PaintingFence() {
    }

    /**
     * Method inherited from Executable interface.
     * uses inputOutput() to show the result
     *
     * @throws InputMismatchException if  in method input() returned value isn't a number.
     */
    @Override
    public void execute() throws InputMismatchException {

        System.out.println("You can paint Your fence posts \n"
                + " in " + inputOutput() + " unique ways.");

    }

    /**
     * Method is scanning console to get number from user.
     * Prints the result of algorithm calculations.
     *
     * @throws InputMismatchException if Scanner nextInt() returned value is not a number
     */
    public int inputOutput() throws InputMismatchException {
        System.out.println("Just tell me how many posts and colors to use.");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the number of posts");
            int posts = in.nextInt();
            System.out.println("Please enter the number of colors");
            int colors = in.nextInt();
            if (posts >= 0 && colors >= 0) {

                return paintFence(posts, colors);
            }
            System.out.println("Sorry but Your number is not positive. Try again");
        }
    }

    /**
     * Performs algorithm logic.
     * if there is 0 post then the ways to color it is 0.
     * if there is one 1 post then ways = colors.
     * loop counts ways to color multiple posts starting from 3 pieces
     *
     * @param post  is the number of posts
     * @param color is amount of colors
     * @return total amount of color combinations
     */
    public int paintFence(int post, int color) {

        if (post == 0) {
            return 0;
        }

        if (post == 1) {
            return color;
        }

        int same = color;
        int diff = color * (color - 1);

        for (int i = 3; i <= post; i++) {
            int prevDiff = diff;
            diff = (same + diff) * (color - 1); //as stated above

            //color the third in another color
            same = prevDiff;
        }

        return same + diff;
    }


}
