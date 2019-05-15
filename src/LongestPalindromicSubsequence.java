import java.util.Scanner;

/**
 * Functionality to find the longest palindromic subsequence in a string.
 *
 * <p>Provides functionality to find the longest palindromic subsequence in a string
 * that is written by a user in console
 * @author Taras Hlukhovetskyi
 */
public class LongestPalindromicSubsequence implements Executable {


    /**
     * A utility function to get the maximum of two integers.
     * @param x first int
     * @param y second int
     * @return int maximum of x and y
     */
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string to be checked for palindromic subsequence");
        String seq = in.nextLine();
        System.out.println("The length of the lps is "
                + findLongestPalindromicSubsequenceLength(seq));
    }


    /**
     * Finds the length of the longest palindromic subsequence in the string.
     * @param sequence string as a sequence
     * @return int length of the longest palindromic subsequence
     */
    public int findLongestPalindromicSubsequenceLength(String sequence) {
        int n = sequence.length();
        if (n == 0) {
            return 0;
        }
        int i;
        int j;
        int cl;
        // Create a table to store results of subtasks
        int[][] subtaskAnswers = new int[n][n];

        // Strings of length 1 are palindromes of length 1
        for (i = 0; i < n; i++) {
            subtaskAnswers[i][i] = 1;
        }

        // cl is length of substring
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (sequence.charAt(i) == sequence.charAt(j)) {
                    if (cl == 2) {
                        subtaskAnswers[i][j] = 2;
                    } else {
                        subtaskAnswers[i][j] = subtaskAnswers[i + 1][j - 1] + 2;
                    }
                } else {
                    subtaskAnswers[i][j] = max(subtaskAnswers[i][j - 1], subtaskAnswers[i + 1][j]);
                }
            }
        }

        return subtaskAnswers[0][n - 1];
    }

}
