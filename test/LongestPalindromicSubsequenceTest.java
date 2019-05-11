import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class LongestPalindromicSubsequenceTest {

    LongestPalindromicSubsequence task =
            new LongestPalindromicSubsequence(new Scanner(System.in));

    @Test
    public void max() {
        assertEquals(3, LongestPalindromicSubsequence.max(1, 3));
        assertEquals(3, LongestPalindromicSubsequence.max(-67, 3));
        assertEquals(-45, LongestPalindromicSubsequence.max(-65, -45));
    }

    @Test
    public void findLongestPalindromicSubsequenceLength() {
        assertEquals(0, task.findLongestPalindromicSubsequenceLength(""));
        assertEquals(1, task.findLongestPalindromicSubsequenceLength("1"));
        assertEquals(1, task.findLongestPalindromicSubsequenceLength("A"));
        assertEquals(1, task.findLongestPalindromicSubsequenceLength("ABCDEFGHIJKLMNOPQRSTU"));
        assertEquals(2, task.findLongestPalindromicSubsequenceLength("AABB"));
        assertEquals(4 ,task.findLongestPalindromicSubsequenceLength("ABCDEEAB"));
    }
}