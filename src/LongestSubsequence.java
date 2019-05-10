import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSubsequence implements Executable{
    private Scanner scan;

    public LongestSubsequence(Scanner scan) {
        this.scan = scan;
    }

    @Override
    public void execute() {
        List<Integer> setOfNumbers = inputValues();

        int counter = 1;
        int maxSequenceLength = 1;
        for (int i = 0; i < setOfNumbers.size() - 1; i++) {
            if ((setOfNumbers.get(i + 1) - setOfNumbers.get(i)) == 1) {
                counter += 1;
                if (maxSequenceLength < counter) {
                    maxSequenceLength = counter;
                }
            } else {
                counter = 1;
            }

        }
        System.out.println("Maximal length of subsequence: " + maxSequenceLength);
    }

    private List<Integer> inputValues() {
        System.out.println("Input a set of integer numbers: ");
        System.out.println("To finish entering numbers input any non-integer value.");
        List<Integer> setOfNumbers = new ArrayList<>();
        while (scan.hasNextInt()) {
            setOfNumbers.add(scan.nextInt());
        }
        return setOfNumbers;
    }
}
