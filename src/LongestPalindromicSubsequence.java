import java.util.Scanner;

public class LongestPalindromicSubsequence implements Executable {

    private Scanner in;
    private int numberOfFib;

    public LongestPalindromicSubsequence(Scanner in) {
        this.in = in;
    }

    // A utility function to get the maximum of two integers
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    @Override
    public void execute() {
        System.out.println("Input string to be checked for palindromic subsequence");
        String seq = in.nextLine();
        System.out.println("The length of the lps is " + lps(seq));
    }

    // Returns the length of the longest
    // palindromic subsequence in seq
    public static int lps(String seq) {
        int n = seq.length();
        if (n == 0) {
            return 0;
        }
        int i, j, cl;
        // Create a table to store results of subtasks
        int L[][] = new int[n][n];

        // Strings of length 1 are palindromes of length 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;


        // cl is length of substring
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j))
                    if (cl == 2)
                        L[i][j] = 2;
                    else
                        L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = max(L[i][j - 1], L[i + 1][j]);
            }
        }

        return L[0][n - 1];
    }

}
