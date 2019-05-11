import java.util.InputMismatchException;
import java.util.Scanner;

public class PaintingFence implements Executable{

    private Scanner in;
    private int posts;
    private int colors;

    public PaintingFence(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() throws InputMismatchException {

        System.out.println("Do you wanna know how many unique ways You can paint fence posts? Just tell me how many posts and colors to use.");
        while (true) {
            System.out.println("Please enter the number of posts");
            int posts = in.nextInt();
            System.out.println("Please enter the number of colors");
            int colors = in.nextInt();
            if (posts >= 0 && colors>=0) {

                System.out.println("You can paint Your fence posts in " + paintFence(posts, colors)+ " unique ways. But You'd better chose one color;)");
                break;
            }
            System.out.println("Sorry but Your number is not positive. Try again");
        }

    }



    public int paintFence(int post, int color) {
        //if there is 0 post then the ways to color it is 0.
        if(post == 0) return 0;

        //if there is one 1 post then it can ways = colors.
        if(post == 1) return color;

        //same - ways to color posts the same color. diff = ways to color them in different color
        int same = color * 1;
        int diff = color * (color -1);

        //loop counts ways to color multiple posts starting from 3 pieces
        for(int i=3;i <=post; i++) {
            int prevDiff = diff;
            diff = (same + diff) * (color - 1); //as stated above

            //color the third in another color
            same = prevDiff * 1;
        }

        return same + diff;
    }

}
