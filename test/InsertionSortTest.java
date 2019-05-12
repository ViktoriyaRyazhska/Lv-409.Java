import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    /**
     * Test sorting algorithm.
     * First create mock input Stream.
     * Then use it to create Scanner and, therefore - Sorting object
     */

    @Test
    public void insertionSortTest() {

        InsertionSort sort = new InsertionSort(new Scanner(System.in));
        int[] actual = {9, 8, 7, 6, 9, 6};
        int[] expected = {6, 6, 7, 8, 9, 9};
        sort.insertionSort(actual);
        assertArrayEquals(expected, actual);

    }

}
