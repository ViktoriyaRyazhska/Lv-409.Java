import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Scanner for work in the main method
    private static final Scanner sc = new Scanner(System.in);

    // List of task classes
    private static final ArrayList<Class <? extends Executable>> classList =
            new ArrayList<Class <? extends Executable>>() {
        {
            add(InsertionSort.class);
            add(CountingSort.class);
            add(QuickSort.class);
            add(BucketSort.class);
            add(MergeSort.class);
            add(Fibonacci.class);
            add(FibonacciMod.class);
            add(LongestSubsequence.class);
            add(WaysToSum.class);
            add(WaysToFigureSum.class);
            add(WaysToCoverInThreeSteps.class);
            add(PathWithoutCrossing.class);
            add(HighOrLowEffort.class);
            add(LongestPalindromicSubsequence.class);
            add(FriendPairs.class);
            add(PaintingFence.class);
            add(OptimizedPaintingFence.class);
        }
    };

    public static void main(String[] args) {

        // Main loop (one loop = one task OR error)
        while (true) {

            try {

                description();

                // Parsing task number
                System.out.println("Enter number of task (1-19) or 0 to exit: ");
                int num = Integer.parseInt(sc.next());

                // Correct input for task number case
                if (num > 0 && num <= classList.size()) {

                    // Executing chosen task
                    try {

                        // Creating new instance for chosen task and calling execute() method
                        classList.get(num-1).getConstructor(Scanner.class).
                                newInstance(new Scanner(System.in)).execute();
                    }

                    // Inner task error
                    catch (Exception e) {
                        System.err.println("Task execution failed.");
                    }

                }

                // Exit number case
                else if (num == 0) {

                    sc.close();
                    System.exit(0);

                }

                // Not existing task number case
                else {

                    System.out.println("Invalid task number.");

                }

            }

            // Not integer input
            catch (NumberFormatException e) {
                System.err.println("Please, enter the number.");
            }

        }

    }

    private static void description() {

        System.out.println(
                "1.Insertion sort\n" +
                "2.Counting sort\n" +
                "3.Quick sort\n" +
                "4.Bucket sort\n" +
                "5.Merge sort\n" +
                "6.Fibonacci\n" +
                "7.Modification Fibonacci\n" +
                "8.Interesting row\n" +
                "9.Longest subsequence with difference one\n" +
                "10.Ways to sum N using array elements with repetition\n" +
                "11.Ways to write n as a sum of two or more positive integers\n" +
                "12.Ways to cover in 3 steps\n" +
                "13.Paths without crossing Virtual programming lab\n" +
                "14.Work to be with High-effort or with Low-effort Virtual programming lab\n" +
                "15.The longest palindromic subsequence\n" +
                "16.Friend pairs\n" +
                "17.Ways to tile the floor\n" +
                "18.Painting the fence\n" +
                "19.Optimized painting fence: use one variable instead of a table"
        );

    }

}
